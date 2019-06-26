package com.lanswon.util.mail;

import java.io.InputStream;
import java.util.Properties;

/**
 * 读取properties文件
 * @author Jasmine
 */
public class ReadProperties {


	/**
	 * 读取文件
	 * @param path 位置
	 * @return properties
	 */
	public static Properties readProperties(String path){
		Properties properties = new Properties();
		try {
			InputStream inputStream = ReadProperties.class.getResourceAsStream("classpath:" + path);

			properties.load(inputStream);
			inputStream.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return properties;
	}
}
