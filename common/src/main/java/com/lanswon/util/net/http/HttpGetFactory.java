package com.lanswon.util.net.http;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 发送GET请求的HTTP工厂
 * @author Jaswine
 */
public class HttpGetFactory implements HttpFactory {

	private Header header;


	private HttpResponse sendRequest(String url) throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		return httpClient.execute(httpGet);
	}

	@Override
	public void sendRequestWithJsonResponse(String url) throws IOException {
		HttpResponse response = sendRequest(url);
		HttpEntity responseEntity = response.getEntity();
		EntityUtils.consume(responseEntity);
	}

	public static void main(String[] args) throws IOException {
		HttpGetFactory httpGetFactory = new HttpGetFactory();
		httpGetFactory.sendRequestWithJsonResponse("http://www.baidu.com");
	}
}
