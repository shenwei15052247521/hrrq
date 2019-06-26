package com.lanswon.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger-ui配置
 *
 * <p>
 *     Swagger API配置
 * </p>
 *
 * @author Jaswine
 */
@Configuration
@EnableSwagger2
@Slf4j
public class Swagger2Config  {

	/**
	 * 创建API
	 * @return api
	 */
	@Bean
	public Docket creatRestApi(){
		log.info("[Swagger2Config]Swagger配置API信息");
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.lanswon.core.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * API信息
	 * @return API信息
	 */
	private ApiInfo apiInfo(){
		log.info("[Swagger2Config]Swagger配置API信息");
		return new ApiInfoBuilder()
				.title("青州市民卡-食堂端")
				.description("青州市民卡在食堂吃饭，结合线下食堂来实时消费，市民卡和人脸识别的加持")
				.termsOfServiceUrl("https://blog.jaswine.club")
				.contact(new Contact("Jaswine","https://blog.jaswine.com","jaswine@163.com"))
				.version("1.0")
				.build();
	}
}

