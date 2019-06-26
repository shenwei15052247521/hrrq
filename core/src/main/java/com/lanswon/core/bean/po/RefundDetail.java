package com.lanswon.core.bean.po;


import lombok.Data;

import java.util.Date;


/**
 * 退费PO
 * @author shenwei
 */
@Data
public class RefundDetail {

	/**
	 * 退费人名称
	 */
	private String userName;
	/**
	 * 退费人所在单位
	 */
	private String department;
	/**
	 * 退费时间
	 */
	private Date recordTime;
	/**
	 * 退费金额
	 */
	private double balance;
	/**
	 * 退费方式
	 */
	private String type;

}
