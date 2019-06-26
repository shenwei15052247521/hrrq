package com.lanswon.core.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 退费申请凭证PO
 * @author Jaswine
 */
@Data
public class RefundTicketVO {

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
	 * 退费金额
	 */
	private double applyMoney;
	/**
	 * 退费方式
	 */
	private String applyType;
	/**
	 * 申请时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date applyTime;
	/**
	 * 处理人id
	 */
	private String applyUserId;
	/**
	 * 处理人姓名
	 */
	private String applyUsername;
	/**
	 * 设备id
	 */
	private String deviceId;
	/**
	 * 设备名称
	 */
	private String deviceName;
}
