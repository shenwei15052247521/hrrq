package com.lanswon.util.crypto;

import com.lanswon.util.codec.EncodingEnum;

import java.security.MessageDigest;

/**
 * MD5加密工具(是基于hash算法实现,不可逆)
 * @author Jasmine
 */
public class Md5 {

	/** 16进制的字符数组 */
	private final static String[] HEX_DIGITS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private Md5(){}
	/**
	 * Md5加密
	 * @param source 需要加密的原字符串
	 * @param encoding 指定编码类型
	 * @param uppercase 是否转为大写字符串
	 * @return String 加密字符串
	 */
	public static String MD5Encode(String source, EncodingEnum encoding, boolean uppercase) throws Exception {
		String result;
		// 获得MD5摘要对象
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		// 使用指定的字节数组更新摘要信息
		messageDigest.update(source.getBytes(encoding.getEncodeing()));
		// messageDigest.digest()获得16位长度
		result = byteArrayToHexString(messageDigest.digest());
		return uppercase ? result.toUpperCase() : result;
	}

	/**
	 * 转换字节数组为16进制字符串
	 * @param bytes 字节数组
	 * @return String 转化后字符串
	 */
	private static String byteArrayToHexString(byte[] bytes) {
		StringBuilder stringBuilder = new StringBuilder();
		for (byte tem : bytes) {
			stringBuilder.append(byteToHexString(tem));
		}
		return stringBuilder.toString();
	}

	/**
	 * 转换byte到16进制
	 * @param b 要转换的byte
	 * @return 16进制对应的字符
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return HEX_DIGITS[d1] + HEX_DIGITS[d2];
	}
}
