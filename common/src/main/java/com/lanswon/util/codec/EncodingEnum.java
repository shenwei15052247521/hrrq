package com.lanswon.util.codec;

/**
 * 字符编码枚举
 * <P>
 *
 * </P>
 * @author Jaswine
 */
public enum EncodingEnum {
	/**
	 *
	 */
	ASCII("ascii"),
	/**
	 *
	 */
	ISO_8859_1("iso-8859-1"),
	/**
	 *
	 */
	GB2312("gb2312"),
	/**
	 *
	 */
	GBK("gbk"),
	/**
	 *
	 */
	GB18030("gb18030"),
	/**
	 *
	 */
	UTF_16("utf-16"),
	/**
	 *
	 */
	UTF_8("UTF-8"),
	/**
	 * UTF-32
	 */
	UTF_32("UTF-32");

	private String encodeing;

	EncodingEnum(String encodeing) {
		this.encodeing = encodeing;
	}

	public String getEncodeing() {
		return this.encodeing;
	}
}
