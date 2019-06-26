package com.lanswon.core.exception;


/**
 * 通用异常
 *
 * @author Jaswine
 */
public class BaseException extends RuntimeException {

	public BaseException(){
		super();
	}

	public BaseException(String message){
		super(message);
	}
}
