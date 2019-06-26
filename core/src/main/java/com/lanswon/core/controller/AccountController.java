package com.lanswon.core.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户操作Controller
 *
 * <p>
 *     账户相关操作API(和钱相关)
 *     0.激活账户
 *     1.消费
 *     2.充值
 *     3.退费
 * </p>
 *
 * @author Jaswine
 */
@RestController
@RequestMapping("/account")
@Slf4j
@Api(value = "AccountController")
public class AccountController {

//	@Resource
//	private AccountService accountService;
//
//	/**
//	 * 开启账户
//	 * @param userId 用户id
//	 * @return res
//	 */
//	@PutMapping("/start/{userId}")
//	@ApiOperation(value = "开启账户",notes = "启用账户")
//	@ResponseBody
//	public DTO startAccount(@PathVariable String userId){
//		log.info("开通用户id为{"+userId+"}的账号");
//		return accountService.startAccount(userId);
//	}


}
