package com.lanswon.core.controller;

import com.lanswon.web.dto.DTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sw
 */
@RestController
@RequestMapping(value = "/webservice")
@Slf4j(topic = "WebserviceController")
public class WebserviceController {



	/**

	 */
	@PostMapping
	@ResponseBody
	@RequestMapping(value = "/demo")
	@ApiOperation(value = "所有交易记录")
	public DTO demo(){

			return null;
	}




}
