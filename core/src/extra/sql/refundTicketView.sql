CREATE VIEW refund_ticket AS
  SELECT
         t2.ticket_seq AS ticketSeq,
         t3.acct_id AS acctId,
         t4.acct_user_smkno AS smkNo,
         t1.record_money AS applyMoney,
         CASE (t1.record_ref_type) WHEN 0 THEN '现金' WHEN 1 THEN '支付包' WHEN  2 THEN  '微信' END AS applyType,
         t1.record_ref_datetime as applyTime,
         t1.record_ref_req_user AS applyUserId,
         t5.sys_nickname AS applyUsername,
         t1.record_ref_deviceid AS deviceId,
         t6.device_name AS deviceName
  FROM record_refund t1
         LEFT JOIN record_ticket t2 ON t1.record_ref_ticket_seq = t2.ticket_seq_id
         LEFT JOIN account t3 ON t1.record_acct_id = t3.acct_id
         LEFT JOIN acct_user t4 ON t4.acct_userid = t3.acct_userid
         LEFT JOIN sys_user t5 ON t1.record_ref_req_user = t5.sys_userid
         LEFT JOIN device t6 ON t1.record_ref_deviceid = t6.device_id
