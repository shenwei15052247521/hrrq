package com.lanswon.core.enums;



/**
 * 食堂消费支付方式
 *
 * <p>
 *     支付方式，暂时支持市民卡和人脸
 *     可以扩展二维码扫码支付等等
 * </p>
 *
 * @author Jaswine
 */
public enum PayTypeEnum {

	/**
	 * 市民卡
	 */
	SMK(0,"市民卡"),
	/**
	 * 人脸
	 */
	FACE(1,"人脸");

	private int code;
	private String payType;
	PayTypeEnum(int code,String payType){
		this.code = code;
		this.payType = payType;
	}

	public int getCode(){
		return this.code;
	}
	public String getPayType(){
        return this.payType;
	}

}
