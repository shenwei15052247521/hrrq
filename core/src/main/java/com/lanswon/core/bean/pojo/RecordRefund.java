package com.lanswon.core.bean.pojo;


import lombok.Data;

import java.util.Date;

/**
 * 退费记录实体类
 * <p>
 * 对应数据库中表{@code record_refund}
 * </P>
 *
 * @author Jaswine
 */
@Data
public class RecordRefund {

	/**
	 * 退费记录id
	 */
	private String recordId;
	/**
	 * 退费账户
	 */
	private String recordAcctId;
	/**
	 * 退费前余额
	 */
	private double recordBfRefund;
	/**
	 * 退费后余额
	 */
	private double recordAfRefund;
	/**
	 * 退费金额
	 */
	private double recordMoney;
	/**
	 * 申请退费设备id
	 */
	private String recordRefDeviceId;
	/**
	 * 申请退费操作员id
	 */
	private String recordRefReqUser;
	/**
	 * 退费方式
	 * @see com.lanswon.core.enums.MoneyTypeEnum
	 */
	private int recordType;
	/**
	 * 申请退费日期
	 */
	private Date recordRefDateTime;
	/**
	 * 申请退费凭证id
	 */
	private String recordRefTicketSeq;

}
