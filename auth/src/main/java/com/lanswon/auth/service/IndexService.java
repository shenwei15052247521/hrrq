package com.lanswon.auth.service;


import com.lanswon.web.dto.DTO;


/**
 * 首页service
 *
 * @author Jaswine
 */
public interface IndexService {

	/**
	 * 获得菜单
	 * @param uid 用户id
	 * @return res
	 */
    DTO getMenus(String uid);

}
