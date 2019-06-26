package com.lanswon.core.bean.po;


import lombok.Data;


/**
 * 充值PO
 * @author Jaswine
 */
@Data
public class LoadInfo {

	/**
	 * 充值方式
	 */
	private String type;
	/**
	 * 充值次数
	 */
	private int count;
	/**
	 * 充值总金额
	 */
	private double loadMoney;
	/**
	 * 提现手续费
	 */
	private double fees;
	/**
	 * 充值凭证数
	 */
	private int ticketCount;

}
