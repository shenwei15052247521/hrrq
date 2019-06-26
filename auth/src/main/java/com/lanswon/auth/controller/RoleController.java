package com.lanswon.auth.controller;


import com.lanswon.auth.bean.pojo.Role;
import com.lanswon.auth.service.RoleService;
import com.lanswon.web.dto.DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 角色相关API
 * @author Jaswine
 */
@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {

	@Resource
	private RoleService roleService;

	/**
	 * 增
	 * @param role 角色信息
	 * @return
	 */
	@PostMapping
	public DTO addRole(@RequestBody Role role){
		log.info("新增角色信息_开始");
		return roleService.addRole(role);
	}

	/**
	 * 删
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public DTO delRole(@PathVariable String id){
		log.info("删除角色信息_开始");
		return roleService.delRole(id);
	}

	/**
	 * 改
	 * @param role
	 * @return
	 */
	@PutMapping
	public DTO updateRole(@RequestBody Role role){
		log.info("更新角色信息_开始");
		return roleService.updateRole(role);
	}

	/**
	 * 查
	 * @return
	 */
	@GetMapping
	public DTO getRoleInfo(){
		log.info("获得角色信息_开始");
		return roleService.getRoleInfo();
	}

	/**
	 * 查-->roleId
	 * @param roleId 角色id
	 * @return res
	 */
	@GetMapping("/{roleId}")
	public DTO getRoleInfoByRoleId(@PathVariable String roleId){
		log.info("roleid-->角色信息_开始");
		return roleService.getRoleInfoByRoleId(roleId);
	}

	@PostMapping("/permission")
	public DTO roleBindPermission(@RequestBody Map<String,String> map){
		log.info("角色绑定权限_开始");
		return roleService.roleBindPermission(map);
	}

	@DeleteMapping("/permission")
	public DTO roleUnbindPermission(@RequestBody Map<String,String> map){
		log.info("角色解绑权限_开始");
		return roleService.roleUnbindPermission(map);
	}
}
