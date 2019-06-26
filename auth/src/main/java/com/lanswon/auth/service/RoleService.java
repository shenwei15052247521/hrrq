package com.lanswon.auth.service;

import com.lanswon.auth.bean.pojo.Role;
import com.lanswon.web.dto.DTO;

import java.util.Map;

/**
 * 角色service
 * @author Jaswine
 */
public interface RoleService {
	/**
	 * 新增角色信息
	 * @param role 角色信息
	 * @return res
	 */
	DTO addRole(Role role);

	DTO delRole(String id);

	DTO updateRole(Role role);

	/**
	 * 获得角色信息
	 * @return res
	 */
	DTO getRoleInfo();

	/**
	 * 查-->roleId
	 * @param roleId 角色id
	 * @return res
	 */
	DTO getRoleInfoByRoleId(String roleId);

	/**
	 * 角色绑定权限
	 * @param map 参数
	 * @return res
	 */
	DTO roleBindPermission(Map<String, String> map);

	DTO roleUnbindPermission(Map<String, String> map);
}
