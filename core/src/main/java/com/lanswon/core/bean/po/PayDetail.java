package com.lanswon.core.bean.po;


import lombok.Data;

import java.util.Date;


/**
 * 消费PO
 * @author shenwei
 */
@Data
public class PayDetail {
	/**
	 * 消费人名字
	 */
	private String userName;
	/**
	 * 所在单位
	 */
	private String department;
	/**
	 * 消费时间
	 */
	private Date recordTime;
	/**
	 * 消费金额
	 */
	private double balance;
	/**
	 * 消费方式
	 */
	private String type;

}
