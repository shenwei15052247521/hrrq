package com.lanswon.core.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 消费返回参数
 *
 * @author Jaswine
 */
@Data
public class PayVO {

	/**
	 * 消费前金额
	 */
	private double balanceBF;
	/**
	 * 消费后金额
	 */
	private double balanceAF;
	/**
	 * 消费时间(20181212101010)
	 */
	@JsonFormat(pattern = "yyyyMMddHHmmss",timezone = "GMT+8")
	private Date time;

}
