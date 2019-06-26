package com.lanswon.core.bean.po;

import lombok.Data;

import java.util.Date;

/**
 * 退费PO
 * @author Jaswine
 */
@Data
public class RefundReportPO {


	/**
	 * 申请退费数
	 */
	private String months;

	/**
	 * 申请退费数
	 */
	private int totalReqRefund;

	/**
	 * 退费笔数
	 */
	private int totalConfirmRefund;

	/**
	 * 申请退费金额
	 */
	private double totalReqRefundMoney;

	/**
	 * 确认退费金额
	 */
	private double totalHaveRefundMoney;

	/**
	 * 未退费金额
	 */
	private double totalNoneRefundMoney;

	/**
	 * 申请退费凭证数
	 */
	private int totalReqRefundTicket;

	/**
	 * 退费完成凭证数
	 */
	private int totalConfirmRefundTicket;

	/**
	 * 生成时间
	 */
	private Date generateDate;



}
