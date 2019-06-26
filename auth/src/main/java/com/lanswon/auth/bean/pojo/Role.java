package com.lanswon.auth.bean.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 角色
 * @author Jaswine
 */
public class Role {

	/**
	 * id
	 */
	@Getter
	@Setter
	private String id;
	/**
	 * 角色名(中文)
	 */
	@Getter
	@Setter
	private String roleNameZH;
	/**
	 * 角色名(英文)
	 */
	@Getter
	@Setter
	private String roleNameEN;
	/**
	 * 权限
	 */
	@Getter
	@Setter
	private List<Permission> permissionList;
}
