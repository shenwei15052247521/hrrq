package com.lanswon.core.bean.vo;

import com.lanswon.core.bean.po.PayInfoPO;
import lombok.Data;

import java.util.List;

/**
 * 月度消费VO
 * @author Jaswine
 */
@Data
public class MonthlyPayVO {

	/**
	 * 设备id
	 */
	private String deviceId;
	/**
	 * 月度统计_次
	 */
	private int totalTime;
	/**
	 * 月度统计_钱
	 */
	private double totalMoney;
	/**
	 * 月度统计_详情
	 */
	private List<PayInfoPO> payInfoList;

}
