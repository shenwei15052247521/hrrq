package com.lanswon.core.bean.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 报表实体类
 *
 *
 * @author Jaswine
 */
@Data
public class RecordEntityVo {

	/**
	 * 交易日期
	 */
	@Excel(name = "交易日期",orderNum = "0")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private String recordTime;
//	/**
//	 * 账户编号
//	 * @see com.lanswon.core.enums.ReporTypeEnum
//	 */
//	@Excel(name="账户编号",orderNum = "1")
//	private String acctId;
	/**
	 * 用户部门
	 */
	@Excel(name = "用户部门",orderNum = "2")
	private String department;
	/**
	 * 用户姓名
	 */
	@Excel(name="用户姓名",orderNum = "3")
	private String userName;
	/**
	 * 交易类型
	 */
	@Excel(name = "交易类型",orderNum = "4")
	private String typt;
	/**
	 * 交易方式
	 */
	@Excel(name="交易方式",orderNum = "5")
	private String type;
	/**
	 * 交易前余额
	 */
	@Excel(name = "交易前余额(元)",orderNum = "6")
	private double bfBalance;
	/**
	 * 交易金额
	 */
	@Excel(name="交易金额(元)",orderNum = "7")
	private double balance;
	/**
	 * 交易后余额
	 */
	@Excel(name = "交易后余额(元)",orderNum = "8")
	private double afBalance;
}
