package com.lanswon.core.bean.dto;

import lombok.Data;

/**
 * 充值参数DTO
 * @author Jaswine
 */
@Data
public class LoadDTO {

	/**
	 * 账户id
	 */
	private String acctId;
	/**
	 * 充值金额
	 */
	private  double money;
	/**
	 * 设备id
	 */
	private String deviceId;
	/**
	 * 请求者id
	 */
	private String reqUserId;
	/**
	 * 充值方式
	 */
	private int loadType;
}
