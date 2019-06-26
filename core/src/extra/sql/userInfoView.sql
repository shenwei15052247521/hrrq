
# 用户信息视图
CREATE VIEW userInfo AS
  SELECT
         t3.acct_id AS acctId,
         t1.acct_userid         AS userId,
         t1.acct_username       AS userName,
         t1.acct_useridentifyid AS idCard,
         t1.acct_user_smkno AS smkNo,
         CASE (t1.acct_sex) WHEN 0 THEN '女' WHEN 1 THEN '男' WHEN '2' THEN '未知' ELSE '未知' END AS sex,
         t1.remark              AS remark,
         t1.acct_faceId AS faceId,
         t1.user_type as userTypeCode,
         case (t1.user_type) when 1 then '临时用户' when 2 then '正式用户' else '未知' end as userType,
         t1.acct_userdepart AS deptId,
         t2.gov_departname      AS deptname,
         t3.acct_balance AS balance ,
         t3.acct_opendate AS openDate,
         t3.acct_startdate AS startDate,
         t3.acct_enddate AS endDate,
         t3.acct_status AS statusId,
         t4.uri AS faceUrl,
         CASE (t3.acct_status) WHEN 0 THEN '已开通' WHEN 1 THEN '未启用' WHEN 2 THEN '注销'  WHEN 3 THEN '退费' ELSE '未知' END AS status
  FROM acct_user t1
         LEFT JOIN department t2 ON t1.acct_userdepart = t2.gov_departid
         LEFT JOIN account t3 ON t1.acct_userid = t3.acct_userid
         LEFT JOIN face_info t4 ON t1.acct_faceId = t4.fk_face_id ;