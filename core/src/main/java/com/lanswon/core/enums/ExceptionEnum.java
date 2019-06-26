package com.lanswon.core.enums;


/**
 * 异常枚举
 *
 * @author Jaswine
 */
public enum  ExceptionEnum {

	/** 事务异常 */
	ERROR_TRANSACTION("事务异常...");

	private String msg;

	ExceptionEnum(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return this.msg;
	}


}
