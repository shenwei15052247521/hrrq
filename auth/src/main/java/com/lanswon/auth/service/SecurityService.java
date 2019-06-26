package com.lanswon.auth.service;


import com.lanswon.auth.bean.pojo.User;
import com.lanswon.web.dto.DTO;

/**
 * 权限service
 * @author Jaswine
 */
public interface SecurityService {

	/**
	 * 登录
	 * @param user 用户信息
	 * @return 登录信息
	 * @throws Exception 异常
	 */
	DTO login(User user) throws Exception;

	/**
	 * 登出
	 * @return res
	 */
	DTO logout();

	/**
	 * 获得初始页信息
	 * @return res
	 */
	DTO index();

}
