package com.lanswon.core.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 交易流水
 *
 * @author Jaswine
 */
@Data
public class StatementVO {

	/**
	 * 交易类型
	 */
	private String typt;
	/**
	 * 交易时间
	 */
	@JsonFormat(pattern = "yyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date recordTime;
	/**
	 * 账户编号
	 */
	private String acctId;
	/**
	 * 交易前余额
	 */
	private double bfBalance;
	/**
	 * 交易金额
	 */
	private double balance;
	/**
	 * 交易后余额
	 */
	private double afBalance;
	/**
	 * 交易方式(现金，支付宝，微信)
	 */
	private String type;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 部门
	 */
	private String department;
	/**
	 * 设备id
	 */
	private String deviceId;
	/**
	 * 交易凭证号
	 */
	private String seq;

}
