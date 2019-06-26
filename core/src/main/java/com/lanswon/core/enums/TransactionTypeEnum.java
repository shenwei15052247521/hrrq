package com.lanswon.core.enums;


/**
 * 交易类型枚举
 *
 * @author Jaswine
 */
public enum TransactionTypeEnum {
	/**
	 * 消费
	 */
	PAY(0,"消费"),
	/**
	 * 充值
	 */
	LOAD(1,"充值"),
	/**
	 * 退费
	 */
	REFUND(2,"申请退费");

	private int code;
	private String type;
	TransactionTypeEnum(int code,String type){
		this.code = code;
		this.type = type;
	}

	public int getCode(){
		return this.code;
	}
	public String getPayType(){
		return this.type;
	}
}
