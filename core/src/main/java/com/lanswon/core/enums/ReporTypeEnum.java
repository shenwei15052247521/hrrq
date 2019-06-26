package com.lanswon.core.enums;

/**
 * 报表类型
 *
 * <p>
 *      生成报表的类型
 * </p>
 *
 * @author Jaswine
 */
public enum ReporTypeEnum {

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
	REFUND(2,"退费");

	private int code;
	private String type;
	ReporTypeEnum(int code, String type){
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
