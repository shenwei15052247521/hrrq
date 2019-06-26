package com.lanswon.auth.service;


import com.lanswon.auth.bean.pojo.Permission;
import com.lanswon.web.dto.DTO;

/**
 * 权限Service
 * @author Jaswine
 */
public interface PermissionService {

	/**
	 * 新增
	 * @param permission 权限信息
	 * @return res
	 */
	DTO addPermission(Permission permission);

	/**
	 * 删除
	 * @param permissionid 权限id
	 * @return res
	 */
	DTO delPermission(String permissionid);

	/**
	 * 修改
	 * @param permission 权限信息
	 * @return res
	 */
	DTO updatePermission(Permission permission);

	/**
	 * 获得所有权限信息
	 * @return res
	 */
	DTO getPermissionInfo();

	/**
	 * 根据id获得权限信息
	 * @param id 权限id
	 * @return res
	 */
	DTO getPermissionInfoById(String id);

}
