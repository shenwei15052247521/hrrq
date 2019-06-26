package com.lanswon.auth.controller;

import com.lanswon.auth.bean.pojo.User;

import com.lanswon.auth.service.IndexService;
import com.lanswon.auth.service.SecurityService;
import com.lanswon.web.dto.DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 权限相关API
 * @author Jaswine
 */
@RestController
@Slf4j
public class SecurityController {

	@Resource
	private SecurityService securityService;

	@Resource
	private HttpServletRequest request;

	@Resource
	private HttpServletResponse response;

	@Resource
	private IndexService indexService;



	/**
	 * 登录
	 * @param user 用户信息
	 * @return 登录信息
	 */
	@PostMapping("/login")
	public DTO login(@RequestBody User user) throws Exception {
		log.info("[SecurityController]登录开始");
		DTO dto =  securityService.login(user);
//		if(dto.) {
//			HttpSession session = request.getSession();
//			Set<MenuVO> set = indexService.getMenus(user.getId());
//			List<String> uriList = new ArrayList<String>();
//			for(MenuVO menuVo:set) {
//				uriList.add(menuVo.getPermission_url());
//			}
//			session.setAttribute("authUris",uriList);
//		}
		return dto;
	}

	/**
	 * 登出
	 * @return 登出信息
	 */
	@GetMapping("/logout")
	public DTO logout(){
		log.info("[SecurityController]登出开始");
		return securityService.logout();
	}

}
