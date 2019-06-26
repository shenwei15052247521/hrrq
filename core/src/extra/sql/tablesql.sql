
CREATE TABLE `gov_sysuser` (

  `sys_userid` varchar(100) NOT NULL COMMENT '系统用户id，食堂-1001，财务-1002',

  `sys_userpsw` varchar(255) NOT NULL DEFAULT '' COMMENT '系统用户密码',

  `sys_name` varchar(255) NOT NULL COMMENT '用户操作员姓名',

  `sys_age` int(3) UNSIGNED NULL COMMENT '操作员姓名',

  `sys_gender` int(4) NULL DEFAULT 0 COMMENT '性别，男-1，女-0',

  `remark` varchar(255) NULL COMMENT '备注',

  PRIMARY KEY (`sys_userid`)

);



CREATE TABLE `account` (

  `acct_id` varchar(100) NOT NULL COMMENT '账户id',

  `acct_balance` decimal(5,2) NOT NULL DEFAULT 0.0 COMMENT '账户余额，使用decimal数据类型，最大值为999.99',

  `acct_opendate` datetime NULL COMMENT '账户开户日期-用户前往开通账户的日期',

  `acct_startdate` datetime NULL COMMENT '账户启用日期，用户要求启用的账户日期，默认情况与开户日期相同',

  `acct_enddate` datetime NULL COMMENT '账户有效日期，默认为启用日期后100年',

  `acct_userid` varchar(100) NOT NULL COMMENT '账户用户id',

  `acct_status` int(2) UNSIGNED NULL DEFAULT 1 COMMENT '账户状态, 0-开通，1-未启用，2-注销 3-退费申请 4-退费完成',

  PRIMARY KEY (`acct_id`)

);



CREATE TABLE `gov_acct_user` (

  `acct_userid` varchar(100) NOT NULL COMMENT '账户用户id',

  `acct_username` varchar(18) NULL COMMENT '账户用户姓名',

  `acct_useridentifyid` varchar(18) NULL COMMENT '账户用户身份证号',

  `acct_user_smkno` varchar(12) NULL COMMENT '账户绑定的市民卡号',

  `acct_userdepart` int(10) NULL COMMENT '账户用户所在部门id（fk）',

  `acct_sex` int(4) NULL DEFAULT 0 COMMENT '性别，男-1，女-0',

  `remark` varchar(255) NULL COMMENT '备注',

  PRIMARY KEY (`acct_userid`)

);



CREATE TABLE `gov_info_depart` (

  `gov_departid` varchar(100) NOT NULL COMMENT '部门id',

  `gov_departname` varchar(255) NULL COMMENT '部门名称',

  PRIMARY KEY (`gov_departid`)

);



CREATE TABLE `gov_record_load` (

  `record_id` varchar(100) NOT NULL COMMENT '充值记录id',

  `record_acct_id` int(11) NULL COMMENT '账户id',

  `record_load` int(10) NULL DEFAULT 0 COMMENT '充值金额，单位元。如100.00充值额，存储为10000',

  `record_bf_load` int(10) NULL DEFAULT 0 COMMENT '账户充值钱余额',

  `record_af_load` int(10) NULL DEFAULT 0 COMMENT '账户充值后余额',

  `record_load_date` datetime NULL COMMENT '充值日期，yyyymmdd',

  `record_load_time` int(6) NULL COMMENT '充值时间，hhmmss',

  `record_load_deviceid` int(11) NULL COMMENT '充值设备编号',

  `record_load_type` int(1) NOT NULL COMMENT '充值类型，1-现金，2-支付宝，3-微信',

  `record_sysuser_id` int(11) NULL COMMENT '充值系统用户id',

  `record_ticket_seq` int(11) UNSIGNED NULL COMMENT '凭证序列号',

  PRIMARY KEY (`record_id`)

);



CREATE TABLE `gov_record_purchase` (

  `record_id` varchar(100) NOT NULL COMMENT '消费记录id',

  `record_acct_id` int(11) NULL,

  `record_pur` int(10) UNSIGNED NULL DEFAULT 0 COMMENT '消费金额',

  `record_bf_pur` int(10) UNSIGNED NULL DEFAULT 0 COMMENT '消费前余额',

  `record_af_pur` int(10) UNSIGNED NULL DEFAULT 0 COMMENT '消费后余额',

  `record_pur_date` datetime NULL COMMENT '消费日期',

  `record_pur_time` int(6) NULL COMMENT '消费时间，hhmmss',

  `record_pur_deviceid` int(11) NULL COMMENT '消费终端编号',

  `record_pur_type` bit NULL COMMENT '消费方式，0-市民卡，1-人脸',

  PRIMARY KEY (`record_id`)

);



CREATE TABLE `gov_info_device` (

  `device_id` varchar(100) NOT NULL COMMENT '设备编号',

  `device_type` bit NULL DEFAULT 0 COMMENT '设备类型，0-充值设备，1-消费设备',

  `device_name` varchar(255) NULL,

  `device_ip` varchar(255) NULL DEFAULT '0.0.0.0' COMMENT '设备ip地址',

  `device_port` int(5) NULL DEFAULT 0 COMMENT '设备端口',

  `device_location` varchar(255) NULL COMMENT '设备所在位置',

  PRIMARY KEY (`device_id`)

);



CREATE TABLE `gov_record_refund` (

  `record_id` varchar(100) NOT NULL COMMENT '退费记录id',

  `record_acct_id` int(11) NULL COMMENT '退费账户id',

  `record_bf_refund` int(11) UNSIGNED NULL COMMENT '退费前余额',

  `record_af_refund` int(11) NULL COMMENT '退费后余额',

  `record_ref_date` datetime NULL COMMENT '退费日期',

  `record_ref_time` varchar(6) NULL COMMENT '退费时间，hhmmss',

  `record_ref_money` int(11) NULL DEFAULT 0 COMMENT '退费金额',

  `record_ref_req_user` int(11) NULL COMMENT '退费申请操作员id（FK）',

  `record_ref_confirm_user` int(11) NULL COMMENT '退费确认系统用户id',

  `record_ticket_seq` int(11) UNSIGNED NULL COMMENT '退费凭证序列号',

  `record_ref_status` int(2) UNSIGNED NULL COMMENT '退费状态，1-申请退费，2-完成退费',

  PRIMARY KEY (`record_id`)

);



CREATE TABLE `gov_info_tickettype` (

  `ticket_type_id` varchar(100) NOT NULL COMMENT '凭证类型id',

  `ticket_name` varchar(255) NULL COMMENT '凭证名称',

  PRIMARY KEY (`ticket_type_id`)

);



CREATE TABLE `gov_ticket_record` (

  `ticket_seq_id` varchar(100) NOT NULL COMMENT '凭证序列号id',

  `ticket_seq` varchar(20) NOT NULL COMMENT '凭证序列号',

  `ticket_type` int(255) UNSIGNED NOT NULL COMMENT '凭证类型',

  `ticket_date` datetime NOT NULL COMMENT '凭证打印日期',

  `ticket_time` varchar(255) NOT NULL COMMENT '凭证打印时间，hhmmss',

  PRIMARY KEY (`ticket_seq_id`)

)

  COMMENT='ticket_seq-凭证序列号\n\n序列号命名规则： YYYYMMDD+XXXXXX\n\nYYYYMMDD：打印凭证的当天日期\nXXXXXX：顺序递增的号，范围 000001-999999\n'
;



CREATE TABLE `gov_sys_params` (

  `param_rate` float(4,0) NULL COMMENT '手续费率，固定值 0.003',

  `param_acct_valid_default` int(2) NULL COMMENT '账户默认有效期，单位=年',

  `param_acct_valid_temp` int(3) NULL COMMENT '账户临时有效期，单位=天',

  `param_acct_pur_daytop` int(10) NULL COMMENT '账户当日消费限额，单位=分，12345 = 123.45 元',

  `param_acct_pur_timetop` int(10) NULL COMMENT '账户每次消费限额，单位=分，12345 = 123.45 元',

  `param_time_start_bf` varchar(255) NULL COMMENT '早餐开始时间，hhmmss',

  `param_time_end_bf` varchar(255) NULL COMMENT '早餐截止时间，hhmmss',

  `param_amount_bf` int(10) NULL COMMENT '早餐单词固定消费金额',

  `param_time_start_lunch` varchar(255) NULL COMMENT '午餐开始时间，hhmmss',

  `param_time_end_lunch` varchar(255) NULL COMMENT '早餐截止时间，hhmmss',

  `param_amount_lunch` int(10) NULL COMMENT '午餐单词固定消费金额',

  `param_time_start_dinner` varchar(255) NULL COMMENT '晚餐开始时间，hhmmss',

  `param_time_end_dinner` varchar(255) NULL COMMENT '晚餐截止时间，hhmmss',

  `param_amount_dinner` int(10) NULL COMMENT '晚餐单词固定消费金额',

  `param_time_start_other` varchar(255) NULL COMMENT '其他就餐开始时间，hhmmss',

  `param_time_end_other` varchar(255) NULL COMMENT '其他就餐截止时间，hhmmss',

  `param_amount_other` int(10) NULL COMMENT '其他就餐时间单词固定消费金额'

)

  COMMENT='系统参数表\n\n金额字段单位都以“分”计，如，123.45 = 12345 分'
;



CREATE TABLE `gov_report_daily` (

  `report_id` varchar(100) NOT NULL COMMENT '报表编号\n报表编号规则：d[m|y] r-类型-日期\n\ndr = daily report 缩写\nmr = month report 缩写\nyr = year report 缩写\n\n类型:\nload = 充值\npurchase = 消费\nrefund = 退费\n\n日期：\n日报表 = yyyymmdd\n月报表 = yyyymm\n年报表 = yyyy\n',

  `report_type` tinyint(2) NULL COMMENT '报表类型',

  `report_date` varchar(10) NULL COMMENT '报表日期\n1、日报表日期格式：yyyymmdd\n2、月报表日期：yyyymm\n3、年报表日期：yyyy',

  `report_detail` text NULL COMMENT '报表数据的json字符串值,{ ...}',

  PRIMARY KEY (`report_id`)

)

  COMMENT='日报表记录表\nreport_detail字段取值范例：\n\n充值日报表：\n{\n  “report_info”: [\n    {\n      \"load_type\": \"现金支付\",\n      \"load_times\": 100,\n      \"load_amount\": \"10000.00\",\n      \"load_cash\": \"10000.00\",\n      \"load_bank\": \"0.00\",\n      \"load_tickets\": 100\n    },\n    {\n      \"load_type\": \"线上支付\",\n      \"load_times\": 30,\n      \"load_amount\": \"3000.00\",\n      \"load_cash\": \"0.00\",\n      \"load_bank\": \"2991.00\",\n      \"load_tickets\": 30\n    }\n  ],\n  \"total_times\": 130,\n  \"total_load_amount\": \"13000.00\",\n  \"total_cash\": \"10000.00\",\n  \"total_bank\": \"2991.00\",\n  \"total_tickets\": 130,\n  \"report_gen_date\": \"yyyy-mm-dd\"\n}\n\n消费日报表：\n{\n  “report_info”: [\n    {\n      \"device_id\": \"001\",\n      \"purchase_times\": 500,\n      \"purchase_amount\": \"2000.00\"\n    },\n    {\n      \"device_id\": \"001\",\n      \"purchase_times\": 500,\n      \"purchase_amount\": \"2000.00\"\n    },\n    {\n      \"device_id\": \"001\",\n      \"purchase_times\": 500,\n      \"purchase_amount\": \"2000.00\"\n    }\n  ],\n  \"report_gen_date\": \"yyyy-mm-dd\"\n}\n\n退费日报表：\n{\n  \"report_info\": {\n    \"refund_req_times\": 100,\n    \"refund_done_times\": 20,\n    \"refund_req_amount\": \"100.00\",\n    \"refund_done_amount\": \"80.00\",\n    \"refund_undo_amount\": \"100.00\",\n    \"refund_req_tickets\": 100,\n    \"refund_done_tickets\": 80\n  },\n  \"report_gen_date\": \"yyyy-mm-dd\"\n}\n\n\n'
;



CREATE TABLE `gov_report_type` (

  `report_type` varchar(100) NOT NULL COMMENT '报表类型\n1-充值日报表\n2-充值月报表\n3-充值年报\n4-消费日报表\n5-消费月报表\n6-消费年报表\n7-退费日报表\n8-退费月报表\n9-退费年报表',

  `report_name` varchar(10) NULL COMMENT '报表类型名称'

);



CREATE TABLE `gov_report_month` (

  `report_id` varchar(100) NOT NULL COMMENT '报表编号\n报表编号规则：d[m|y] r-类型-日期\n\ndr = daily report 缩写\nmr = month report 缩写\nyr = year report 缩写\n\n类型:\nload = 充值\npurchase = 消费\nrefund = 退费\n\n日期：\n日报表 = yyyymmdd\n月报表 = yyyymm\n年报表 = yyyy\n',

  `report_type` tinyint(2) NULL COMMENT '报表类型',

  `report_date` varchar(10) NULL COMMENT '报表日期\n1、日报表日期格式：yyyymmdd\n2、月报表日期：yyyymm\n3、年报表日期：yyyy',

  `report_detail` text NULL,

  PRIMARY KEY (`report_id`)

)

  COMMENT='月报表记录表\n\nreport_detail字段取值范例：\n\n充值月报表：\n{\n  “report_info”: [\n    {\n      \"load_type\": \"现金支付\",\n      \"load_times\": 100,\n      \"load_amount\": \"10000.00\",\n      \"load_cash\": \"10000.00\",\n      \"load_bank\": \"0.00\",\n      \"load_tickets\": 100\n    },\n    {\n      \"load_type\": \"线上支付\",\n      \"load_times\": 30,\n      \"load_amount\": \"3000.00\",\n      \"load_cash\": \"0.00\",\n      \"load_bank\": \"2991.00\",\n      \"load_tickets\": 30\n    }\n  ],\n  \"total_times\": 130,\n  \"total_load_amount\": \"13000.00\",\n  \"total_cash\": \"10000.00\",\n  \"total_bank\": \"2991.00\",\n  \"total_tickets\": 130,\n  \"report_gen_date\": \"yyyy-mm-dd\"\n}\n\n消费月报表：\n{\n  “report_info”: [\n    {\n      \"device_id\": \"001\",\n      \"purchase_times\": 500,\n      \"purchase_amount\": \"2000.00\"\n    },\n    {\n      \"device_id\": \"001\",\n      \"purchase_times\": 500,\n      \"purchase_amount\": \"2000.00\"\n    },\n    {\n      \"device_id\": \"001\",\n      \"purchase_times\": 500,\n      \"purchase_amount\": \"2000.00\"\n    }\n  ],\n  \"report_gen_date\": \"yyyy-mm-dd\"\n}\n\n退费月报表：\n{\n  \"report_info\": {\n    \"refund_req_times\": 100,\n    \"refund_done_times\": 20,\n    \"refund_req_amount\": \"100.00\",\n    \"refund_done_amount\": \"80.00\",\n    \"refund_undo_amount\": \"100.00\",\n    \"refund_req_tickets\": 100,\n    \"refund_done_tickets\": 80\n  },\n  \"report_gen_date\": \"yyyy-mm-dd\"\n}\n\n\n'
;



CREATE TABLE `gov_report_year` (

  `report_id` varchar(100) NOT NULL COMMENT '报表编号\n报表编号规则：d[m|y] r-类型-日期\n\ndr = daily report 缩写\nmr = month report 缩写\nyr = year report 缩写\n\n类型:\nload = 充值\npurchase = 消费\nrefund = 退费\n\n日期：\n日报表 = yyyymmdd\n月报表 = yyyymm\n年报表 = yyyy\n',

  `report_type` tinyint(2) NULL COMMENT '报表类型',

  `report_date` varchar(10) NULL COMMENT '报表日期\n1、日报表日期格式：yyyymmdd\n2、月报表日期：yyyymm\n3、年报表日期：yyyy',

  `report_detail` text NULL,

  PRIMARY KEY (`report_id`)

)

  COMMENT='充值年统计报表\n\nreport_detail字段取值范例：\n\n充值年统计报表：\n{\n  \"report_info\": [\n    {\n      \"month\": \"2018-01\",\n      \"cash_load_times\": 100,\n      \"cash_load_amount\": \"1000.00\",\n      \"online_load_times\": 100,\n      \"online_load_amount\": \"1000.00\",\n      \"cash_income\": \"1000.00\",\n      \"bank_income\": \"1000.00\",\n      \"load_tickets\": 1000\n    },\n    {\n      ...\n    },\n    {\n      \"month\": \"2018-12\",\n      \"cash_load_times\": 100,\n      \"cash_load_amount\": \"1000.00\",\n      \"online_load_times\": 100,\n      \"online_load_amount\": \"1000.00\",\n      \"cash_income\": \"1000.00\",\n      \"bank_income\": \"1000.00\",\n      \"load_tickets\": 1000\n    },\n    \n  ],\n  \"total_cash_amount\": \"20000.00\",\n  \"total_cash_income\": \"20000.00\",\n  \"total_online_amount\": \"25000.00\",\n  \"total_bank_income\": \"24000.00\",\n  \"rate_charge\": \"80.00\",\n  \"report-gen-date\": \"yyyy-mm-dd\"\n}\n\n消费年报表：\n\n{\n  \"report_info\": [\n    {\n      \"month\": \"2018-01\",\n      \"purchase_times\": 100,\n      \"purchase_amount\": \"2000.00\"\n    },\n    {\n       …..\n    },\n    {\n      \"month\": \"2018-12\",\n      \"purchase_times\": 500,\n      \"purchase_amount\": \"2000.00\"\n    }\n  ],\n  \"report_gen_date\": \"yyyy-mm-dd\"\n}\n\n\n\n\n退费年报表：\n{\n  \"report_info\": [\n    {\n      \"month\": \"2018-01\",\n      \"refund_req_times\": 2,\n      \"refund_done_times\": 2,\n      \"refund_req_amount\": \"100.00\",\n      \"refund_done_amount\": \"100.00\",\n      \"refund_req_tickets\": 2,\n      \"refund_done_tickets\": 2\n    },\n    {\n      ...\n    },\n    {\n      \"month\": \"2018-12\",\n      \"refund_req_times\": 2,\n      \"refund_done_times\": 2,\n      \"refund_req_amount\": \"100.00\",\n      \"refund_done_amount\": \"100.00\",\n      \"refund_req_tickets\": 2,\n      \"refund_done_tickets\": 2\n    }\n  ],\n  \"total_refund_req_times\": 2,\n  \"total_refund_done_times\": 2,\n  \"total_refund_req_amount\": \"100.00\",\n  \"total_refund_done_amount\": \"100.00\",\n  \"total_refund_req_tickets\": 2,\n  \"total_refund_done_tickets\": 2,\n  \"refund_undo_times\": 2,\n  \"refund_undo_amount\": \"\"100.00,\n  \"report_gen_date\": \"yyyy-mm-dd\"\n}\n\n\n'
;



CREATE TABLE `gov_report_info` (

  `report_id` varchar(100) NOT NULL COMMENT '报表编号',

  PRIMARY KEY (`report_id`)

);
