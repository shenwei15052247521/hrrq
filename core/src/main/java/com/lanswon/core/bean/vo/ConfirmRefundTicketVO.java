package com.lanswon.core.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 确认退费凭证VO
 * @author Jaswine
 */
@Data
public class ConfirmRefundTicketVO {

	/**
	 * 凭证号
	 */
	private String ticketSeq;
	/**
	 * 账户id
	 */
	private String acctId;
	/**
	 * 市民卡号
	 */
	private String smkNo;
	/**
	 * 确认退费金额
	 */
	private double confirmMoney;
	/**
	 * 退费方式
	 */
	private String confirmType;
	/**
	 * 确认时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date confirmTime;
	/**
	 * 操作人id
	 */
	private String confirmUserId;
	/**
	 * 操作人姓名
	 */
	private String confirmUsername;
	/**
	 * 设备id
	 */
	private String deviceId;
	/**
	 * 设备名称
	 */
	private String deviceName;

}
