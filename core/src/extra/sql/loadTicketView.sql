CREATE VIEW loadTicket AS
SELECT
       CASE(t6.ticket_type) WHEN 0 THEN '消费凭证' WHEN 1 THEN '充值凭证' WHEN 2 THEN '退费凭证' END AS tickeTypeName,
       t6.ticket_seq AS ticketNo,
       t2.acct_id AS accountId,
       t3.acct_user_smkno AS smkNo,
       t1.record_bf_load AS bfLoad,
       t1.record_load AS loadNo,
       t1.record_af_load AS afLoad,
       CASE(t1.record_load_type) WHEN '0' THEN '现金' WHEN '1' THEN '支付宝' WHEN '2' THEN '微信' ELSE '未知' END AS loadType,
       t1.record_load_datetime AS loadDateTime,
       t4.sys_name AS sysName,
       t4.sys_userid AS sysUserId,
       t5.device_name AS deviceName,
       t5.device_id AS deviceId
FROM record_load t1
       left JOIN account t2 ON t1.record_acct_id = t2.acct_id
       left JOIN acct_user t3 ON t2.acct_userid = t3.acct_userid
       left JOIN sys_user t4 ON t1.record_sysuser_id = t4.sys_userid
       left JOIN device t5 ON t1.record_load_deviceid = t5.device_id
       left join record_ticket t6 on t1.record_ticket_seq = t6.ticket_seq_id;
