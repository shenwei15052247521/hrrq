package com.lanswon.auth.controller;

import com.lanswon.auth.bean.pojo.User;
import com.lanswon.auth.service.UserService;
import com.lanswon.web.dto.DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 系统用户的操作
 * <p>
 *     使用系统的用户
 * </p>
 * @author Jaswine
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Resource
	private UserService userService;


	/**
	 * 增
	 * @param user 用户信息
	 * @return res
	 */
	@PostMapping
	public DTO addUser(@RequestBody User user) throws Exception {
		log.info("新增用户开始");
		return userService.addUser(user);
	}

	/**
	 * 删
	 * @param id 用户id
	 * @return res
	 */
	@DeleteMapping("/{id}")
	public DTO delUser(@PathVariable String id){
		log.info("删除用户开始");
		return userService.delUser(id);
	}

	/**
	 * 改
	 * @param user 用户角色
	 * @return res
	 */
	@PutMapping()
	public DTO updateUser(@RequestBody User user){
		log.info("修改用户开始");
		return userService.updateUser(user);
	}

	/**
	 * 查
	 * @return res
	 */
	@GetMapping
	public DTO getUserInfo(){
		log.info("查询所有用户开始");
		return userService.getUserInfo();
	}

	/**
	 * id-->用户信息
	 * @param id 用户id
	 * @return res
	 */
	@GetMapping("/{id}")
	public DTO getUserInfoByUserId(@PathVariable String id){
		log.info("id-->用户信息");
		return userService.getUserInfoByUserId(id);
	}

	/**
	 * 用户绑定角色
	 * @param map
	 * {
	 *   "userid":"564441",
	 *   "roleid":"154612"
	 * }
	 * @return res
	 */
	@PostMapping("/role")
	public DTO userBindRole(@RequestBody Map<String,String> map){
		log.info("用户绑定角色");
		return userService.userBindRole(map);
	}


	/**
	 * 用户解除角色绑定
	 * @param map
	 * {
	 *   "userid":"564441",
	 *   "roleid":"154612"
	 * }
	 * @return res
	 */
	@DeleteMapping("/role")
	public DTO userUnbindRole(@RequestBody Map<String,String> map){
		log.info("用户解绑角色");
		return userService.userUnbindRole(map);
	}
}
