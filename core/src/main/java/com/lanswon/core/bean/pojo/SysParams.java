package com.lanswon.core.bean.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

/**
 * 系统参数
 * @author Jaswine
 * @date 2018-12-13 CST
 */
@Data
public class SysParams {

	/**
	 * id
	 */
	private String paramId;
	/**
	 * 手续费率(固定值0.003)
	 */
	private double rate;
	/**
	 * 默认有效期(年)
	 */
	private int validDefault;
	/**
	 * 临时有效期(天)
	 */
	private int validTemp;
	/**
	 * 消费限额(分) - 当日
	 */
	private double purDaytop;
	/**
	 * 消费限额(分) - 每次
	 */
	private double purTimetop;
	/**
	 * 早餐开始时间
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	private Time timeStartBf;
	/**
	 * 早餐结束时间
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	private Time timeEndBf;
	/**
	 * 早餐单次金额
	 */
	private double amountBf;
	/**
	 * 午餐开始时间
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	private Time timeStartLunch;
	/**
	 * 午餐结束时间
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	private Time timeEndLunch;
	/**
	 * 午餐固定金额
	 */
	private double amountLunch;
	/**
	 * 晚餐开始时间
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	private Time timeStartDinner;
	/**
	 * 晚餐结束时间
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	private Time timeEndDinner;
	/**
	 * 晚餐固定金额
	 */
	private double amountDinner;
	/**
	 * 其他就餐开始时间
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	private Time timeStartOther;
	/**
	 * 其他就餐结束时间
	 */
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
	private Time timeEndOther;
	/**
	 * 其他就餐金额
	 */
	private double amountOther;

}
