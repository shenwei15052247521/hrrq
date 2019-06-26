package com.lanswon.core.bean.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 充值详情持久化对象
 * <p>
 *     报表信息定期持久化保存对象
 *
 *     日报，月报，年报 通用对象
 * </p>
 * @author Jaswine
 */
@Data
public class LoadReportDetailPO {


	/**
	 * 月份
	 */
	private String months;

	/**
	 * 总充值次数
	 */
	private int loadCount;
	/**
	 * 总充值金额
	 */
	private double loadMoney;
	/**
	 * 充值凭证数
	 */
	private int ticketCount;
	/**
	 * 生成时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date reportGenDate;
	/**
	 * 详情
	 */
	private List<LoadInfo> loadInfoList;

    /**
     * 详情
     */
    private List<LoadDetail> loadDeatilList;









}
