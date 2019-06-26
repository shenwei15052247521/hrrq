package com.lanswon.auth.bean.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 菜单(权限)
 *
 * @author Jaswine
 */
public class Permission {

	/**
	 * id
	 */
	@Getter
	@Setter
	private String id;
	/**
	 * 父id
	 */
	@Getter
	@Setter
	private String pid;
	/**
	 * 菜单URL
	 */
	@Getter
	@Setter
	@NotNull(message = "权限URL不能为空")
	@NotBlank(message = "权限URL不能为空")
	private String permissionUrl;
	/**
	 * 菜单名称
	 */
	@Getter
	@Setter
	private String permissionName;
	/**
	 * 描述
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * 子菜单
	 */
	@Getter
	@Setter
	private List<Permission> childrenPermissions;
	/**
	 * 类型
	 */
	@Getter
	@Setter
	private String type;

}
