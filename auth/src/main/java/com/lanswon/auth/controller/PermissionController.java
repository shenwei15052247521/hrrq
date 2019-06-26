package com.lanswon.auth.controller;

import com.lanswon.auth.bean.pojo.Permission;
import com.lanswon.auth.service.PermissionService;
import com.lanswon.web.dto.DTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.scene.chart.ValueAxis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 权限controller
 * @author Jaswine
 */
@RestController
@RequestMapping("/permission")
@Slf4j
@Api(value = "PermissionController")
public class PermissionController {

	@Resource
	private PermissionService permissionService;

	/**
	 * 新增
	 * @param permission 权限信息
	 * @return res
	 */
	@PostMapping
	@ApiOperation(value = "新增权限")
	public DTO addPermission(@RequestBody Permission permission){
		log.info("新增权限信息");
		return permissionService.addPermission(permission);
	}

	/**
	 * 删除
	 * @param permissionid 权限id
	 * @return res
	 */
	@DeleteMapping("/{permissionid}")
	@ApiOperation(value = "删除权限")
	public DTO delPermission(@PathVariable String permissionid){
		log.info("删除权限信息");
		return permissionService.delPermission(permissionid);
	}

	/**
	 * 修改
	 * @param permission 权限信息
	 * @return res
	 */
	@PutMapping
	@ApiOperation(value = "更新权限")
	public DTO updatePermission(@RequestBody Permission permission){
		log.info("更新权限信息");
		return permissionService.updatePermission(permission);
	}

	/**
	 * 获得所有权限信息
	 * @return res
	 */
	@GetMapping
	@ApiOperation("获得权限信息")
	public DTO getPermissionInfo(){
		log.info("获得权限信息");
		return permissionService.getPermissionInfo();
	}

	/**
	 * 根据id获得权限信息
	 * @param id 权限id
	 * @return res
	 */
	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获得权限信息")
	public  DTO getPermissionInfoById(@PathVariable String id){
		log.info("获得"+id+"权限信息");
		return permissionService.getPermissionInfoById(id);
	}
}
