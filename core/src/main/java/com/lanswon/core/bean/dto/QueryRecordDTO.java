package com.lanswon.core.bean.dto;


import lombok.Data;

import java.util.Date;

/**
 * 交易记录查询DTO
 *
 * @author Jaswine
 */
@Data
public class QueryRecordDTO {

	/**
	 * 交易类型
	 */
	private String type;
	/**
	 * 开始时间
	 */
	private Date starTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 金钱类型
	 */
	private int moneyType;
	/**
	 * 账户id
	 */
	private String acctId;
	/**
	 * 部门id
	 */
	private String departmentId;
	/**
	 * 凭证号
	 */
	private String ticketSeq;
	/**
	 * 用户姓名
	 */
	private String userName;

}
