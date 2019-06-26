package com.lanswon.auth.controller;

import com.lanswon.auth.service.IndexService;
import com.lanswon.web.dto.DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 首页controller
 *
 * <p>首页加载的时候返回的信息</p>
 *
 * @author Jaswine
 */
@RestController
@RequestMapping("/index")
@Slf4j
public class IndexController {

	@Resource
	private IndexService indexService;

	@GetMapping("/menu/{uid}")
	public DTO getMenus(@PathVariable String uid) {
		log.info("查询所有菜单");
		return indexService.getMenus(uid);
	}

}
