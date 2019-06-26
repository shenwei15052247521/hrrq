CREATE VIEW statement AS
  SELECT CASE (t14.ticket_type) WHEN 0 THEN '消费' WHEN 1 THEN '充值' WHEN 2 THEN '退费' END AS typt,
         t1.record_load_datetime AS recordTime,
         t1.record_acct_id       AS acctId,
         t1.record_bf_load       AS bfBalance,
         t1.record_load          AS balance,
         t1.record_af_load       AS afBalance,
         t1.record_load_type AS moneyType,
         CASE (t1.record_load_type) WHEN 0 THEN '现金' WHEN 1 THEN '支付宝' WHEN 2 THEN '微信' END AS type,
         t12.acct_username       AS userName,
         t13.gov_departid AS departmentid,
         t13.gov_departname      AS department,
         t1.record_load_deviceid AS deviceId,
         t1.record_ticket_seq    AS seq
  FROM record_load t1
         LEFT JOIN account t11 ON t11.acct_id = t1.record_acct_id
         LEFT JOIN acct_user t12 ON t12.acct_userid = t11.acct_userid
         LEFT JOIN department t13 ON t12.acct_userdepart = t13.gov_departid
         LEFT JOIN record_ticket t14 ON t14.ticket_seq_id = t1.record_ticket_seq
  UNION
  SELECT CASE (t24.ticket_type) WHEN 0 THEN '消费' WHEN 1 THEN '充值' WHEN 2 THEN '退费' END AS typt,
         t2.record_pur_datetime AS recordTime,
         t2.record_acct_id      AS acctId,
         t2.record_bf_pur       AS bfBalance,
         t2.record_pur          AS balance,
         t2.record_af_pur       AS afBalance,
         t2.record_pur_type AS moneyType,
         CASE (t2.record_pur_type) WHEN 0 THEN '市民卡' WHEN 1 THEN '人脸' END AS type,
         t22.acct_username      AS userName,
         t23.gov_departid AS departmentid,
         t23.gov_departname     AS department,
         t2.record_pur_deviceid AS deviceId,
         t2.record_ticket_seq   AS seq
  FROM record_purchase t2
         LEFT JOIN account t21 ON t21.acct_id = t2.record_acct_id
         LEFT JOIN acct_user t22 ON t22.acct_userid = t21.acct_userid
         LEFT JOIN department t23 ON t22.acct_userdepart = t23.gov_departid
         LEFT JOIN record_ticket t24 ON t24.ticket_seq_id = t2.record_ticket_seq
  UNION
  SELECT CASE (t34.ticket_type) WHEN 0 THEN '消费' WHEN 1 THEN '充值' WHEN 2 THEN '退费'END AS typt,
         t3.record_ref_datetime AS recordTime,
         t3.record_acct_id      AS acctId,
         t3.record_bf_refund    AS bfBalance,
         t3.record_money    AS balance,
         t3.record_af_refund    AS afBalance,
         t3.record_ref_type AS moneyType,
         CASE (t3.record_ref_type) WHEN 0 THEN '现金' WHEN 1 THEN '支付宝' WHEN 2 THEN '微信' END AS type,
         t32.acct_username      AS userName,
         t33.gov_departid AS departmentid,
         t33.gov_departname     AS department,
         t3.record_ref_deviceid     AS deviceId,
         t3.record_ref_ticket_seq   AS seq
  FROM record_refund t3
         LEFT JOIN account t31 ON t31.acct_id = t3.record_acct_id
         LEFT JOIN acct_user t32 ON t32.acct_userid = t31.acct_userid
         LEFT JOIN department t33 ON t32.acct_userdepart = t33.gov_departid
         LEFT JOIN record_ticket t34 ON t34.ticket_seq_id = t3.record_ref_ticket_seq