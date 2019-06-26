//package com.lanswon.core.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 消息队列配置
// */
//@Configuration
//public class RabbitmqConfig {
//
//	@Autowired
//	private RabbitProperties rabbitProperties;
//
//	/**消息编码*/
//	public static final String MESSAGE_ENCODING = "UTF-8";
//	public static final String EXCHANGE_ISSUE = "exchange_message_issue";
//	public static final String QUEUE_ISSUE_USER = "queue_message_issue_user";
//	public static final String QUEUE_ISSUE_ALL_USER = "queue_message_issue_all_user";
//	public static final String QUEUE_ISSUE_ALL_DEVICE = "queue_message_issue_all_device";
//	public static final String QUEUE_ISSUE_CITY = "queue_message_issue_city";
//	public static final String ROUTING_KEY_ISSUE_USER = "routing_key_message_issue_user";
//	public static final String ROUTING_KEY_ISSUE_ALL_USER = "routing_key_message_issue_all_user";
//	public static final String ROUTING_KEY_ISSUE_ALL_DEVICE = "routing_key_message_issue_all_device";
//	public static final String ROUTING_KEY_ISSUE_CITY = "routing_key_message_issue_city";
//	public static final String EXCHANGE_PUSH = "exchange_message_push";
//	public static final String QUEUE_PUSH_RESULT = "queue_message_push_result";
//
//	@Bean
//	public Queue issueUserQueue(){
//		return new Queue(QUEUE_ISSUE_ALL_USER);
//	}
//
//	@Bean
//	public Queue issueAllUserQueue() {
//		return new Queue(QUEUE_ISSUE_ALL_USER);
//	}
//
//	@Bean
//	public Queue issueAllDeviceQueue() {
//		return new Queue(QUEUE_ISSUE_ALL_DEVICE);
//	}
//
//	@Bean
//	public Queue issueCityQueue() {
//		return new Queue(QUEUE_ISSUE_CITY);
//	}
//
//	@Bean
//	public Queue pushResultQueue() {
//		return new Queue(QUEUE_PUSH_RESULT);
//	}
//
//	@Bean
//	public DirectExchange issueExchange() {
//		return new DirectExchange(EXCHANGE_ISSUE);
//	}
//
//	@Bean
//	public DirectExchange pushExchange() {
//		// 参数1：队列
//		// 参数2：是否持久化
//		// 参数3：是否自动删除
//		return new DirectExchange(EXCHANGE_PUSH, true, true);
//	}
//
//	@Bean
//	public Binding issueUserQueueBinding(@Qualifier("issueUserQueue") Queue queue, @Qualifier("issueExchange") DirectExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_ISSUE_USER);
//	}
//
//	@Bean
//	public Binding issueAllUserQueueBinding(@Qualifier("issueAllUserQueue") Queue queue, @Qualifier("issueExchange") DirectExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_ISSUE_ALL_USER);
//	}
//
//	@Bean
//	public Binding issueAllDeviceQueueBinding(@Qualifier("issueAllDeviceQueue") Queue queue,
//	                                          @Qualifier("issueExchange") DirectExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_ISSUE_ALL_DEVICE);
//	}
//
//	@Bean
//	public Binding issueCityQueueBinding(@Qualifier("issueCityQueue") Queue queue,
//	                                     @Qualifier("issueExchange") DirectExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_ISSUE_CITY);
//	}
//
//	@Bean
//	public Binding pushResultQueueBinding(@Qualifier("pushResultQueue") Queue queue,
//	                                      @Qualifier("pushExchange") DirectExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).withQueueName();
//	}
//
//
//	/**
//	 * rabbitTemplate对象
//	 * @param connectionFactory
//	 * @return
//	 */
//	@Bean
//	public AmqpTemplate rabbitTemplate(@Qualifier("defaultConnectionFactory") ConnectionFactory connectionFactory){
//		return new RabbitTemplate(connectionFactory);
//	}
//
//	@Bean
//	public ConnectionFactory defaultConnectionFactory() {
//		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//		connectionFactory.setHost(rabbitProperties.getHost());
//		connectionFactory.setPort(rabbitProperties.getPort());
//		connectionFactory.setUsername(rabbitProperties.getUsername());
//		connectionFactory.setPassword(rabbitProperties.getPassword());
//		connectionFactory.setVirtualHost(rabbitProperties.getVirtualHost());
//		return connectionFactory;
//	}
//
//	@Bean
//	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(@Qualifier("defaultConnectionFactory") ConnectionFactory connectionFactory) {
//		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//		factory.setConnectionFactory(connectionFactory);
//		factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//		return factory;
//	}
//}
