package com.lanswon.core.bean.dto;

import lombok.Data;

/**
 * 退费申请参数DTO
 * @author Jaswine
 */
@Data
public class RefundDTO {

	/**
	 * 账户id
	 */
	private String acctId;
	/**
	 * 申请操作员id
	 */
	private String reqUserId;
	/**
	 * 确认操作员id
	 */
	private String confirmUserId;
	/**
	 * 设备id
	 */
	private String deviceId;
	/**
	 * 退费方式
	 * 0:现金
	 * 1:微信
	 * 2:支付宝
	 */
	private Integer moneyType;
}
