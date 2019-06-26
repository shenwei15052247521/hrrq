package com.lanswon.web.dto;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 数据传输对象(DateTransferObject)
 * <p>
 *      建议在参数传递过程中尽量使用Dto来传递<br>
 *      该类提供 复杂的返回类型 {key:value,key:value...}
 * </p>
 *
 * @author Jaswine
 */
public abstract class BaseDto extends HashMap implements DTO, Serializable {

	private static final long serialVersionUID = 284380656518226384L;

	/**
	 * 设置返回状态码
	 * @param status 状态码
	 */
	@Override
	public void setStatus(int status) {
		this.put("status", status);
	}

	/**
	 * 设置返回提示信息
	 * @param msg 提示信息
	 */
	@Override
	public void setMsg(String msg) {
		this.put("msg", msg);
	}

	/**
	 * 设置返回的数据
	 * @param obj 信息实体
	 */
	@Override
	public void setData(Object obj) {
		this.put("data", obj);
	}

	/**
	 * token
	 * @param token 令牌
	 */
	public abstract void setToken(String token);

}
