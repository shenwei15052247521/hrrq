package com.lanswon.auth.mapper;

import com.lanswon.auth.bean.pojo.Role;
import com.lanswon.auth.bean.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Jaswine
 */
@Repository
public interface RoleMapper {



	/**
	 * 新增角色
	 * @param role 角色信息
	 * @return res
	 */
	boolean addRoleInfo(@Param("role") Role role);

	/**
	 * 删除角色
	 * @param id 角色id
	 * @return res
	 */
	boolean delRole(String id);

	/**
	 * 更新角色信息
	 * @param role 角色
	 * @return res
	 */
	boolean updateRole(@Param("role") Role role);

	/**
	 * 获得所有角色信息
	 * @return res
	 */
	List<Role> getRoleInfo();

	/**
	 * userid-->role
	 * @param id 用户id
	 * @return res
	 */
	List<Role> findRolesByUserId(String id);

	/**
	 * roleid-->ROLE
	 * @param roleId 角色id
	 * @return res
	 */
	Role getRoleInfoByRoleId(String roleId);

	/**
	 * 新增 用户&角色
	 * @param user 用户信息
	 * @return res
	 */
	boolean addUserRole(@Param("user") User user);

	/**
	 * 新增 角色&权限
	 * @param roleId 角色id
	 * @param permissionArray 权限数组
	 * @return res
	 */
	boolean addRolePermission(String roleId,String[] permissionArray);


	/**
	 * role绑定权限
	 * @param map 参数
	 * @return res
	 */
	boolean roleBindPermission(@Param("map")Map<String, String> map);

	boolean roleUnbindPermission(@Param("map")Map<String, String> map);

	boolean delPermission2Role(String id);

	boolean delRole2User(String id);


	//////utils///////

	/**
	 * 角色是否绑定权限
	 * @param map 参数
	 * @return res
	 */
	boolean hasRoleBundPermission(@Param("map") Map<String, String> map);

}
