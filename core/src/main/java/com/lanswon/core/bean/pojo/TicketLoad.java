package com.lanswon.core.bean.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 充值凭证实体类
 * <P>
 *      对应的数据库_视图{@code loadTicket}
 * </P>
 * @author Jaswine
 */
@Data
public class TicketLoad {

	/**
	 * 凭证名称
	 */
	private String tickeTypeName;
	/**
	 * 凭证序列号
	 */
	private String ticketNo;
	/**
	 * 账户id
	 */
	private String accountId;
	/**
	 * 市民卡号
	 */
	private String smkNo;
	/**
	 * 充值前金额
	 */
	private double bfLoad;
	/**
	 * 充值金额
	 */
	private double loadNo;
	/**
	 * 充值后金额
	 */
	private double afLoad;
	/**
	 * 充值类型
	 */
	private String loadType;
	/**
	 * 充值时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date loadDateTime;
	/**
	 * 操作员姓名
	 */
	private String sysName;
	/**
	 * 操作员id
	 */
	private String sysUserId;
	/**
	 * 设备名称
	 */
	private String deviceName;
	/**
	 * 设备id
	 */
	private String deviceId;
}
