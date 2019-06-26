package com.lanswon.web.dto;


/**
 * 数据传输对象
 * @author Jaswine
 */
public interface DTO {
	/**
	 * 设置status对象的状态
	 * @param status 状态
	 */
	void setStatus(int status);

	/**
	 * 设置status对象的提示信息
	 * @param msg 信息
	 */
	void setMsg(String msg);

	/**
	 * 设置数据信息
	 * @param obj 信息实体
	 */
	void setData(Object obj);
}
