package com.lanswon.auth.bean.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 用户实体类
 *
 * <p>
 *     实现了Spring Security对于User的规范
 *
 *     1.用户的权限通过<code>Role</code>这个中间体来联接
 * </p>
 *
 * @author Jaswine
 */
public class User {

	/**
	 * id
	 */
	@Getter
	@Setter
	private String id;
	/**
	 * 用户名
	 */
	@Getter
	@Setter
	@NotNull(message = "用户名不可以为空...")
	private String username;
	/**
	 * 密码
	 */
	@Getter
	@Setter
	@NotNull(message = "密码不可以为空...")
	private String password;
	/**
	 * 昵称
	 */
	@Getter
	@Setter
	@NotNull(message = "昵称不可以为空...")
	private String nickname;
	/**
	 * 年龄
	 */
	@Getter
	@Setter
	private int age;
	/**
	 * 性别
	 */
	@Getter
	@Setter
	private String sex;
	/**
	 * 备注
	 */
	@Getter
	@Setter
	private String remark;
	/**
	 * 角色
	 */
	@Getter
	@Setter
	private List<Role> roleList;
}
