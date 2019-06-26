package com.lanswon.core.bean.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 结果统计VO
 * @author Jaswine
 */
@Data
public class StatementCountVO {




	/**
	 * 起始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date starTime;
	/**
	 * 截止时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date endTime;
	/**
	 * 交易笔数
	 */
	private Integer transCountNum;
	/**
	 * 交易数额
	 */
	private Double transCountMoney;

	/**
	 * 交易类型
	 */
	private String typt;
}
