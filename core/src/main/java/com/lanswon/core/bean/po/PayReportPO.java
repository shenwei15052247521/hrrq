package com.lanswon.core.bean.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * 消费详情持久化对象
 * <p>
 *     报表信息定期持久化保存对象
 *
 *     日报，月报，年报 通用对象
 * </p>
 * @author Jaswine
 */
public class PayReportPO {

	/**
	 * 支付信息
	 */
	@Getter
	@Setter
	private List<PayInfoPO> payInfoPOList;

	/**
	 * 消费时间
	 */
	@Getter
	@Setter
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date genDate;


	/**
	 * 年报支付信息
	 */
	@Getter
	@Setter
	private List<List<PayInfoPO>> yearPayInfoPOList;


	/**
	 * 年报支付信息
	 */
	@Getter
	@Setter
	private List<PayDetail> payDetailList;

}
