package com.lanswon.core.bean.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
public class ReportEntityVo {

	/**
	 * id
	 */
	@Excel(name="日报id",orderNum = "0")
	private String id;
	/**
	 * 报表类型
	 * @see com.lanswon.core.enums.ReporTypeEnum
	 */
	@Excel(name="报表类型",orderNum = "1")
	private int type;
	/**
	 * 类型名称
	 */
	@Excel(name = "类型名称",orderNum = "2")
	private String typeName;
	/**
	 * 时间
	 */
	@Excel(name = "时间",orderNum = "3")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date date;
	/**
	 * 报表详情(Json字符串)
	 */
	@Excel(name = "报表详情",orderNum = "4")
	private String reportDetail;
}
