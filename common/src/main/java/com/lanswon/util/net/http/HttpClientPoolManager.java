package com.lanswon.util.net.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * HTTP客户端连接连接池管理
 * @author Jaswine
 */
public class HttpClientPoolManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientPoolManager.class);

	/**
	 * HTTP_CLIENT连接池管理对象
	 */
	private static PoolingHttpClientConnectionManager poolConnManager = null;
	/**
	 * HTTP_CLIENT
	 */
	private static CloseableHttpClient httpClient;
	/**
	 * 请求参数配置
	 */
	private static RequestConfig requestConfig;
	/**
	 * 最大连接数
	 */
	private static int maxTotal = 100;
	/**
	 * 最大路由
	 */
	private static int maxPerRoute = 2;
	/**
	 * socket超时时间(毫秒/ms)
	 */
	private static int socketTimeout = 10000;
	/**
	 * 连接超时时间(毫秒/ms)
	 */
	private static int connectTimeout = 10000;
	/**
	 * 连接请求超时时间(毫秒/ms)
	 */
	private static int connectionRequestTimeout = 10000;


	/**
	 * 使用默认配置初始化HTTP_CLIENT连接池
	 */
	public static void initDefaultHttpClientPool(){
		try {
			LOGGER.debug("创建SSL对象");
			SSLContextBuilder builder = new SSLContextBuilder();
			builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					builder.build());

			LOGGER.debug("配置同时支持 HTTP 和 HTPPS");
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create().register(
					"http", PlainConnectionSocketFactory.getSocketFactory()).register(
					"https", sslsf).build();

			LOGGER.debug("初始化连接管理器对象:{poolConnManager}");
			poolConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);

			LOGGER.debug("[HttpClientPoolManager]最大连接数为:{"+maxTotal+"}");
			poolConnManager.setMaxTotal(maxTotal);

			LOGGER.debug("[HttpClientPoolManager]设置最大路由为{"+maxPerRoute+"}");
			poolConnManager.setDefaultMaxPerRoute(maxPerRoute);

			LOGGER.debug("[HttpClientPoolManager]设置socket超时时间为:{"+socketTimeout+"}毫秒/ms");
			LOGGER.debug("[HttpClientPoolManager]设置连接超时时间为:{"+connectTimeout+"}毫秒/ms");
			LOGGER.debug("[HttpClientPoolManager]设置请求超时时间为:{"+connectionRequestTimeout+"}毫秒/ms");
			requestConfig = RequestConfig.custom()
					.setConnectionRequestTimeout(connectionRequestTimeout)
					.setSocketTimeout(socketTimeout)
					.setConnectTimeout(connectTimeout)
					.build();

			httpClient = getConnection();
			LOGGER.info("[HttpClientPoolManager]初始化HttpClient连接池成功");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得HTTP_CLIENT连接对象
	 * @return HTTP_CLIENT对象
	 */
	private static CloseableHttpClient getConnection() {

		CloseableHttpClient httpClient = HttpClients.custom()
				// 设置连接池管理
				.setConnectionManager(poolConnManager)
				// 设置请求配置
				.setDefaultRequestConfig(requestConfig)
				// 设置重试次数
				.setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
				.build();

		if (poolConnManager != null && poolConnManager.getTotalStats() != null) {
			System.out.println("now client pool " + poolConnManager.getTotalStats().toString());
		}
		LOGGER.info("[HttpClientPoolManager]创建HTTP_CLIENT成功");
		return httpClient;
	}
}
