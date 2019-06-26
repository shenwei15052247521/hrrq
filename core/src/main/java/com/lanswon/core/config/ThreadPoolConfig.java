package com.lanswon.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 通用线程池配置
 *
 * @author Jaswine
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

	private static final int POOL_SIZE = 10;
	private static final int MAX_POOL_SIZE = 20;
	private static final int QUEUE_CAPATITY = 10;
	private static final int KEEP_ALIVE = 60;

	@Bean
	public Executor defaultExecutor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(POOL_SIZE);
		executor.setMaxPoolSize(MAX_POOL_SIZE);
		executor.setQueueCapacity(QUEUE_CAPATITY);
		executor.setThreadNamePrefix("default-");
		executor.setKeepAliveSeconds(KEEP_ALIVE);

		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.initialize();
		return executor;
	}
}
