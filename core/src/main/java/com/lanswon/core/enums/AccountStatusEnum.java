package com.lanswon.core.enums;


/**
 * 账户状态枚举类
 *
 *  <p>
 *     账户状态的转换
 *  </p>
 *
 * @author Jaswine
 */
public enum  AccountStatusEnum {

	/**
	 * 账户可使用
	 */
	ACTIVATED(0,"账户可使用"),
	/**
	 * 账户未启用
	 */
	INACTIVATED(1,"未启用"),
	/**
	 * 账户已注销
	 */
	OUT_OF_USE(2,"已注销"),
	/**
	 * 退费完成
	 */
	HAVE_REFUND(3,"退费完成");

	private int code;
	private String status;

	AccountStatusEnum(int code,String status){
		this.code = code;
		this.status = status;
	}

	public int getCode(){
		return this.code;
	}

	public String getStatus(){
		return this.status;
	}
}
