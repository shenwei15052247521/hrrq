package com.lanswon.core.enums;



/**
 * 凭证类型
 *
 * <P>
 *     凭证类型枚举类
 * </P>
 *
 * @author Jaswine
 */
public enum  TickeTypeEnum {

	/**
	 * 充值凭证
	 */
	PAY_TICKET(0,"充值凭证"),
	/**
	 * 充值凭证
	 */
	LOAD_TICKET(1,"充值凭证"),
	/**
	 * 申请退费凭证
	 */
	REFUND_TICKET(2,"退费凭证");

	private int code;
	private String ticketName;
	TickeTypeEnum(int code,String ticketName){
		this.code = code;
		this.ticketName = ticketName;
	}

	public int getCode(){
		return this.code;
	}
	public String getTicketName(){
		return this.ticketName;
	}
}
