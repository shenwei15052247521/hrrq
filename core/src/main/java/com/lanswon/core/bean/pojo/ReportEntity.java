package com.lanswon.core.bean.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 报表实体类
 *
 * <p>
 *     报表分为三种类型:
 *      1.日报表
 *      2.月报表
 *      3.年报表
 *     三种报表的数据结构是相同的，内容是不同的，所有使用同一实体类对象
 * </p>
 *
 * @author Jaswine
 */
@Data
public class ReportEntity {

	/**
	 * id
	 */
	private String id;
	/**
	 * 报表类型
	 * @see com.lanswon.core.enums.ReporTypeEnum
	 */
	private int type;
	/**
	 * 类型名称
	 */
	private String typeName;
	/**
	 * 时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date date;
	/**
	 * 报表详情(Json字符串)
	 */
	private String reportDetail;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReportDetail() {
		return reportDetail;
	}

	public void setReportDetail(String reportDetail) {
		this.reportDetail = reportDetail;
	}
}
