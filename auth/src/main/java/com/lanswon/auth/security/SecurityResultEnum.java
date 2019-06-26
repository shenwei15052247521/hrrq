package com.lanswon.auth.security;


import lombok.Getter;

/**
 * Security返回状态
 *
 * @author Jaswine
 */
public enum SecurityResultEnum {

	//---通用---//
	/** SUCCESS */
	SUCCESS(200,"成功","SUCCESS..."),


	//---用户---//
	/** 用户不存在 */
	ERROR_NO_USER(300,"用户不存在","USER DOESN'T EXIST..."),
	/** 用户已存在 */
	ERROR_USER_HAS_EXISTED(301,"用户已存在","USER HAS EXISTED..."),
	/** 密码不正确 */
	ERROR_INCORRECT_PASSWORD(310,"密码不正确","PASSWORD IS INCORRECT..."),
	/** 用户角色为空 */
	ERROR_EMPTY_ROLE(400,"用户角色为空","USER HAS NO ROLE..."),
	/** 用户已经绑定角色 */
	ERROR_USER_HAS_BUND_ROLE(401,"用户已经绑定当前角色","USER HAS BUND ROLE..."),

	//---角色---//
	/** 角色已经绑定权限 */
	ERROR_ROLE_HAS_BUND_PERMISSION(450,"角色已经绑定当前权限","ROLE HAS BUND PERMISSION..."),
	/** 解绑角色失败 */
	ERROR_UNBIND_ROLE_FAILED(451,"解绑角色失败","UNBIND ROLE FAILED..."),


	//---权限---//
	/** 无权限 */
	ERROR_NO_PERMISSION(500,"无权限","NO PERMISSION..."),

	/** SQL错误 */
	ERROR_BAD_SQL(600,"SQL错误","BAD SQL..."),

	/** 空返回信息 */
	ERROR_EMPTY_RESULT(700,"查询结果为空","EMPTY RESULT...");

	@Getter
	private int code;
	@Getter
	private String msgZH;
	@Getter
	private String msgEN;

	SecurityResultEnum(int code, String msgZH, String msgEN){
		this.code = code;
		this.msgZH = msgZH;
		this.msgEN = msgEN;
	}


	@Override
	public String toString() {
		return "SecurityResultEnum{" +
				"code=" + code +
				", msgZH='" + msgZH + '\'' +
				", msgEN='" + msgEN + '\'' +
				'}';
	}
}
