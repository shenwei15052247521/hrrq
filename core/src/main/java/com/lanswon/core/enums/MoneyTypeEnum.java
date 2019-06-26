package com.lanswon.core.enums;

/**
 * 交易类型
 *
 * <P>
 *     统一全局交易类型
 *     同数据库相对应
 * </P>
 *
 * @author Jaswine
 */
public enum  MoneyTypeEnum {

	/**
	 * 现金
	 */
	CASH(0,"现金"),
	/**
	 * 支付宝
	 */
	ALIPAY(1,"支付宝"),
	/**
	 * 微信
	 */
	WECHAT_PAY(2,"微信");

	private int code;
	private String name;
	MoneyTypeEnum(int code,String name){
		this.code = code;
		this.name = name;
	}

	public int getCode(){
		return this.code;
	}
	public  String getName(){
		return this.name;
	}
}
