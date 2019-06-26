package com.lanswon.core.bean.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 消费记录实体类
 * <p>
 * 对应数据库中表{@code record_purchase}
 * </p>
 *
 * @author Jaswine
 */
@Data
public class RecordPay {

	/**
	 * 记录id
	 */
	private String recordId;
	/**
	 * 账户id
	 */
	private String recordAcctId;
	/**
	 * 消费金额
	 */
	private double recordPur;
	/**
	 * 消费前余额
	 */
	private double recordBfPur;
	/**
	 * 消费后余额
	 */
	private double recordAfPur;
	/**
	 * 消费日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date recordPurDateTime;
	/**
	 * 消费pos机id
	 */
	private String recordPurDeviceid;
	/**
	 * 消费方式
	 * @see com.lanswon.core.enums.PayTypeEnum
	 */
	private int recordPurType;
	/**
	 * 凭证号
	 */
	private String recordTicketSeq;

}
