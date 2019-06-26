package com.lanswon.util.crypto;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * Base64加密&解密方式
 * @author Jaswine
 */
public class Base64 {

	private Base64(){}

	/**
	 * BASE64加密
	 * @param key 字节数组
	 * @return 加密字符串
	 */
	public static String encryptBASE64(byte[] key) {
		return (new BASE64Encoder()).encodeBuffer(key);
	}

	/**
	 * BASE64解密
	 * @param key 加密字符
	 * @return 解密字符串
	 * @throws Exception 异常
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}

	public static void main(String[] args) {

	}

}
