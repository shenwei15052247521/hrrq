package com.lanswon.util.net.http;

import java.io.IOException;

/**
 * HTTP请求工厂
 * @author Jaswine
 */
public interface HttpFactory {


	/**
	 * 返回Json数据
	 * @throws IOException IO异常
	 */
	void sendRequestWithJsonResponse(String url) throws IOException;
}
