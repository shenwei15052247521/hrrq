package com.lanswon.core.bean.po;

import lombok.Getter;
import lombok.Setter;

/**
 * 每个设备的消费信息
 *
 */
public class PayInfoPO {


	/**
	 * 设备id
	 */
	@Getter
	@Setter
	private String deviceId;
	/**
	 * 支付次数
	 */
	@Getter
	@Setter
	private int payTimeCount;
	/**
	 * 支付金额
	 */
	@Getter
	@Setter
	private double payMoneyCount;

	/**
	 * 月份
	 */
	@Getter
	@Setter
	private String months;
}
