package com.lanswon.auth.mapper;

import com.lanswon.auth.bean.pojo.Permission;
import com.lanswon.auth.bean.vo.MenuVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 权限信息Mapper
 *
 * <p>
 *     权限信息的操作
 * </p>
 *
 * @author Jaswine
 */
@Repository
public interface PermissionMapper {

	List<Permission> findPermissionsByUserId(String id);

	List<Map<String,String>> findRoleAndPermisson();

	List<Permission> getPermissionByRoleId(String roleId);

	boolean addPermission(@Param("permission") Permission permission);

	boolean delPermission(String permissionid);

	boolean delPermission2Role(String permissionid);

	boolean updatePermission(@Param("permission") Permission permission);

	List<Permission> getPermissionInfo();

	List<Permission> index();

	Permission getPermissionInfoById(String id);

	/**
	 * 根据用户id获得菜单权限
	 * @param uid 用户id
	 * @return res
	 */
	List<MenuVO> getAllMenusByUserId(String uid);
}
