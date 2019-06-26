package com.lanswon.core.enums;


import lombok.Getter;
import lombok.ToString;

/**
 * 封装返回结果类型和状态码
 *
 * <p>
 *     依据业务的具体情况，封装了相关的返回码和返回信息
 * </p>
 *
 * @author Jaswine
 */
@ToString
public enum ResultEnum {

	//---通用状态---//

	/**
	 * 成功
	 */
	SUCCESS(200, "SUCCESS"),
	/**
	 * 错误
	 */
	ERROR(400, "错误"),
	/**
	 * SQl错误
	 */
	SQLERROR(401, "SQL错误，请检查SQL"),
	/**
	 * 参数传入错误
	 */
	PARAMS_ERROR(402, "您传入的参数不对"),
	/**
	 * 结果为空
	 */
	EMPTY_RESULT(403, "结果为空"),
	/**
	 * 没带token
	 */
	ERROR_NO_TOKEN(404, "没有token..."),
	/**
	 * token错误
	 */
	ERROR_INCORRECT_TOKEN(405, "token错误..."),


	//---系统相关---//
	/**
	 * 非用餐时间
	 */
	ERROR_OUT_OF_TIME(500,"非系统设定用餐时间"),

	//---用户相关---//

	/**
	 * 用户已存在
	 */
	ERROR_USER_HAVE_EXISTED(700, "用户已存在"),
	/**
	 * 用户不存在
	 */
	ERROR_USER_NON_EXIST(701, "用户不存在"),
	/**
	 * 数据库中没有用户信息
	 */
	ERROR_USER_NULL(702, "数据库中没有用户信息"),
	/**
	 * 用户已绑定市民卡
	 */
	ERROR_USER_HAVE_BIND_CARD(703, "用户已绑定市民卡"),
	/**
	 * 用户已绑定人脸
	 */
	ERROR_USER_HAVE_BIND_FACE(704, "用户已绑定人脸"),

	/**
	 * 市民卡已经绑定用户
	 */
	ERROR_CARD_HAVE_BIND_USER(705, "市民卡已经绑定用户"),
	/**
	 * 数据库中没有部门信息
	 */
	ERROR_DEPT_NULL(710, "数据库中没有部门信息"),
	/**
	 * 数据库中没有设备信息
	 */
	ERROR_DEVICE_NULL(720, "数据库中没有设备信息"),
	/**
	 * 密码错误
	 */
	ERROR_BAD_PASSWORD(800, "密码错误"),

	//---账户相关--//
	/**
	 * 账户不可用
	 */
	ERROR_ACCOUNT_INACTIVATED(900, "账户不可用，请先激活账户"),
	/**
	 * 账户可用
	 */
	ERROR_ACCOUNT_ACTIVATED(901, "账户可用"),
	/**
	 * 账户余额不足
	 */
	ERROR_ACCOUNT_NO_MONEY(902, "账户余额不足"),
	/**
	 * 账户金额溢出
	 */
	ERROR_ACCOUNT_MONEY_OVERFLOW(903, "账户金额溢出:最大为999.99元"),
	/**
	 * 账户已注销
	 */
	ERROR_ACCOUNT_HAS_LOGOUT(904,"账户已注销"),
	/**
	 * 账户未申请退款
	 */
	ERROR_ACCOUNT_HAS_NOT_APPLY_REFUND(905,"账户未申请退款"),
	/**
	 * 账户已确认退款
	 */
	ERROR_ACCOUNT_HAS_CONFIRM_REFUND(906,"账户已确认退款"),
	/** 账户到期 */
	ERROR_ACCOUNT_HAS_EXPIRED(907,"账户已经到期"),
	//---记录相关---//
	/**
	 * 插入记录失败
	 */
	ERROR_RECORD_INSERT_FAILED(1000,"插入记录失败..."),

	//---凭证相关-----//
	/**
	 * 插入凭证失败
	 */
	ERROR_TICKET_INSERT_FAILED(1100,"插入凭证失败..."),

	//---文件相关---//

	/**
	 * 文件已存在
	 */
	ERROR_FILE_HAS_EXIST(1200,"文件已存在..."),
	/**
	 * 文件上传失败
	 */
	ERROR_FILE_UPLOAD_FAILED(1201,"文件上传失败..."),
	/** 文件删除失败 */
	ERROR_FILE_DELETE_FAILED(1202,"文件删除失败..."),
	/**
	 * 空文件
	 */
	ERROR_FILE_ISEMPTY(1211,"文件为空...");






	/**
	 * 状态码
	 */
	@Getter
	private int code;
	/**
	 * 状态信息
	 */
	@Getter
	private String msg;

	ResultEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
