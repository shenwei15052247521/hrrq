package com.lanswon.util.crypto;


import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA {

	private static final String KEY_SHA = "SHA";

	private SHA(){}

	public static  String  getResult(String inputStr) throws Exception{
		BigInteger sha;
		byte[] inputData = inputStr.getBytes();
		MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
		messageDigest.update(inputData);
		sha = new BigInteger(messageDigest.digest());
		return sha.toString(32);
	}
}
