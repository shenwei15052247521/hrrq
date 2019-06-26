package com.lanswon.core.bean.po;


import lombok.Data;

import java.util.Date;


/**
 * 充值PO
 * @author shenwei
 */
@Data
public class LoadDetail {

	/**
	 * 充值人名称
	 */
	private String userName;
	/**
	 * 充值人所在单位
	 */
	private String department;
	/**
	 * 充值时间
	 */
	private Date recordTime;
	/**
	 * 充值金额
	 */
	private double balance;
	/**
	 * 充值方式
	 */
	private String type;

}
