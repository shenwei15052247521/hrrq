package com.lanswon.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * web mvc配置
 *
 * <p>
 *     1.配置相关拦截器
 *     2.设置编码格式
 *     3.配置跨域访问
 * </p>
 *
 * @author Jaswine
 */
@Configuration
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {
//
//	@Resource
//	private LoadInterceptor loadInterceptor;
//	@Resource
//	private PayInterceptor payInterceptor;
//	@Resource
//	private RefundInterceptr refundInterceptr;

	/**
	 * 拦截器配置
	 * @param registry 注册
	 */
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(loadInterceptor)
//				.addPathPatterns("/account/load");
//		log.info("[WebMvcConfig]配置充值拦截器");
//
//		registry.addInterceptor(payInterceptor)
//				.addPathPatterns("/account/pay");
//		log.info("[WebMvcConfig]配置消费拦截器");
//
//		registry.addInterceptor(refundInterceptr)
//				.addPathPatterns("/account/refund");
//		log.info("[WebMvcConfig]配置退费拦截器");
//
//	}


	/**
	 * 设置响应编码
	 * <p>使用HTTP信息转换器来配置响应体的字符编码</p>
	 * @return 编码格式
	 */
	@Bean
	public HttpMessageConverter<String> responseBodyConverter(){
		log.info("[WebMvcConfig]设置response编码格式为{UTF-8}");
		return new StringHttpMessageConverter(Charset.forName("UTF-8"));
	}

	/**
	 * HTTP内容协商
	 * @param configurer 配置
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		log.info("[WebMvcConfig]配置HTTP内容协商");
		configurer.favorParameter(false);
	}

	/**
	 * 配置swagger-ui
	 * @param registry 注册器
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	/**
	 * HTTP消息转换
	 * @param converters 转换器
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		log.info("[WebMvcConfig]配置HTTP消息转换");
		converters.add(responseBodyConverter());
	}

	/**
	 * 配置跨域访问
	 * @return 跨域访问过滤器
	 */
	@Bean
	public CorsFilter corsFilter(){
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.addAllowedOrigin("*");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",configuration);

		log.info("[WebMvcConfig]配置跨域访问");
		return new CorsFilter(source);
	}
}