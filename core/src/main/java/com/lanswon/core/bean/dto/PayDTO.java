package com.lanswon.core.bean.dto;

import lombok.Data;

/**
 * 消费参数DTO
 * @author Jaswine
 */
@Data
public class PayDTO {

	/**
	 * 市民卡号
	 */
	private String smkid;
	/**
	 * 人脸id
	 */
	private String faceid;
	/**
	 * 消费金额
	 */
	private double money;
	/**
	 * 设备id
	 */
	private String deviceId;

}
