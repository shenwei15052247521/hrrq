package com.lanswon.auth.service;


import com.lanswon.auth.bean.pojo.User;
import com.lanswon.web.dto.DTO;

import java.util.Map;

/**
 * UserService
 * @author Jaswine
 */
public interface UserService {

	/**
	 * 增
	 * @param user 用户信息
	 * @return res
	 */
	DTO addUser(User user) throws Exception;

	/**
	 * 删
	 * @param id 用户id
	 * @return res
	 */
	DTO delUser(String id);

	/**
	 * 改
	 * @param user 用户角色
	 * @return res
	 */
	DTO updateUser(User user);

	/**
	 * 查
	 * @return res
	 */
	DTO getUserInfo();

	/**
	 * id-->用户信息
	 * @param id 用户id
	 * @return res
	 */
	DTO getUserInfoByUserId(String id);

	/**
	 * 用户绑定角色
	 * @param map
	 * {
	 *   "userid":"564441",
	 *   "roleid":"154612"
	 * }
	 * @return res
	 */
	DTO userBindRole(Map<String, String> map);

	/**
	 * 用户解除角色绑定
	 * @param map
	 * {
	 *   "userid":"564441",
	 *   "roleid":"154612"
	 * }
	 * @return res
	 */
	DTO userUnbindRole(Map<String, String> map);
}
