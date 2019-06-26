package com.lanswon.auth.service.impl;

import com.lanswon.auth.bean.pojo.Role;
import com.lanswon.auth.bean.dto.ResultDTO;
import com.lanswon.auth.mapper.PermissionMapper;
import com.lanswon.auth.mapper.RoleMapper;
import com.lanswon.auth.security.SecurityResultEnum;
import com.lanswon.auth.service.RoleService;
import com.lanswon.util.utils.UUIDUtil;
import com.lanswon.web.dto.DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 角色ServiceImpl
 * @author Jaswine
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;
	@Resource
	private PermissionMapper permissionMapper;


	@Override
	public DTO addRole(Role role) {
		DTO dto = new ResultDTO();

		role.setId(UUIDUtil.generateUUID());

		// 新增角色信息
		if (!roleMapper.addRoleInfo(role)){
			log.error("新增角色信息_失败");
			dto.setStatus(SecurityResultEnum.ERROR_BAD_SQL.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_BAD_SQL.getMsgZH());

			log.error(SecurityResultEnum.ERROR_BAD_SQL.toString());
			return dto;
		}

		dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
		dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());

		return dto;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public DTO delRole(String id) {
		DTO dto = new ResultDTO();

		// 删除role信息
		roleMapper.delRole(id);
		// 删除此role关联的permission信息(sys_role_permission)
		roleMapper.delPermission2Role(id);
		// 删除此role关联的user信息(sys_role_user)
		roleMapper.delRole2User(id);

		dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
		dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());

		log.info(SecurityResultEnum.SUCCESS.toString());
		return dto;
	}

	@Override
	public DTO updateRole(Role role) {
		DTO dto = new ResultDTO();

		// 是否修改
		if (!roleMapper.updateRole(role)){
			dto.setStatus(SecurityResultEnum.ERROR_BAD_SQL.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_BAD_SQL.getMsgZH());

			log.info(SecurityResultEnum.ERROR_BAD_SQL.toString());
			return dto;
		}

		dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
		dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());

		log.info(SecurityResultEnum.SUCCESS.toString());
		return dto;
	}

	@Override
	public DTO getRoleInfo() {
		DTO dto = new ResultDTO();

		List<Role> roleInfoList = roleMapper.getRoleInfo();

		// 角色信息为空
		if (roleInfoList.isEmpty()){
			log.error("获得角色信息_为空");

			dto.setStatus(SecurityResultEnum.ERROR_EMPTY_RESULT.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_EMPTY_RESULT.getMsgZH());

			log.error(SecurityResultEnum.ERROR_EMPTY_RESULT.toString());
			return dto;
		}

		ArrayList<Role> roles = new ArrayList<>();
		for (Role role : roleInfoList){
			role.setPermissionList(permissionMapper.findPermissionsByUserId(role.getId()));
			roles.add(role);
		}

		dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
		dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());
		dto.setData(roles);

		log.info(SecurityResultEnum.SUCCESS.toString());
		return dto;
	}

	@Override
	public DTO getRoleInfoByRoleId(String roleId) {
		DTO dto = new ResultDTO();

		Role role = roleMapper.getRoleInfoByRoleId(roleId);

		// 角色为空
		if (role == null){
			dto.setStatus(SecurityResultEnum.ERROR_EMPTY_RESULT.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_EMPTY_RESULT.getMsgZH());

			log.error(SecurityResultEnum.ERROR_EMPTY_RESULT.toString());
			return dto;
		}

		role.setPermissionList(permissionMapper.getPermissionByRoleId(roleId));

		dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
		dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());
		dto.setData(role);

		log.info(SecurityResultEnum.SUCCESS.toString());

		return dto;
	}

	@Override
	public DTO roleBindPermission(Map<String, String> map) {
		DTO dto = new ResultDTO();

		// 判断ROLE 是否绑定 permission
		if (roleMapper.hasRoleBundPermission(map)){
			dto.setStatus(SecurityResultEnum.ERROR_ROLE_HAS_BUND_PERMISSION.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_ROLE_HAS_BUND_PERMISSION.getMsgZH());

			log.error(SecurityResultEnum.ERROR_ROLE_HAS_BUND_PERMISSION.getMsgZH());
			return dto;
		}

		// 绑定
		if (!roleMapper.roleBindPermission(map)){
			dto.setStatus(SecurityResultEnum.ERROR_BAD_SQL.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_BAD_SQL.getMsgZH());

			log.error(SecurityResultEnum.ERROR_BAD_SQL.toString());
			return dto;
		}

		dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
		dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());

		log.info(SecurityResultEnum.SUCCESS.toString());
		return dto;
	}

	@Override
	public DTO roleUnbindPermission(Map<String, String> map) {
		DTO dto = new ResultDTO();

		if (!roleMapper.roleUnbindPermission(map)){

			dto.setStatus(SecurityResultEnum.ERROR_BAD_SQL.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_BAD_SQL.getMsgZH());

			log.info(SecurityResultEnum.ERROR_BAD_SQL.toString());
			return dto;
		}

		dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
		dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());

		log.info(SecurityResultEnum.SUCCESS.toString());
		return dto;
	}

}
