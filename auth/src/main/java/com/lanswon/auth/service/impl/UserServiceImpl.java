package com.lanswon.auth.service.impl;

import com.lanswon.auth.bean.pojo.User;
import com.lanswon.auth.bean.dto.ResultDTO;
import com.lanswon.auth.mapper.RoleMapper;
import com.lanswon.auth.mapper.UserMapper;
import com.lanswon.auth.security.SecurityResultEnum;
import com.lanswon.auth.service.UserService;
import com.lanswon.util.codec.EncodingEnum;
import com.lanswon.util.crypto.Md5;
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
 * 实现类
 * @author Jaswine
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private RoleMapper roleMapper;

	@Override
	public DTO addUser(User user) throws Exception {
		DTO dto = new ResultDTO();

		// 判断用户名是否存在
		if (isUserExist(user.getUsername())){
			dto.setStatus(SecurityResultEnum.ERROR_USER_HAS_EXISTED.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_USER_HAS_EXISTED.getMsgZH());

			log.error(SecurityResultEnum.ERROR_USER_HAS_EXISTED.toString());
			return dto;
		}

		user.setId(UUIDUtil.generateUUID());
		user.setPassword(Md5.MD5Encode(user.getPassword(), EncodingEnum.UTF_8,true));

		if (!userMapper.addUser(user)){
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

	@Transactional(rollbackFor = Exception.class)
	@Override
	public DTO delUser(String id) {

		DTO dto = new ResultDTO();

		// 删除user信息
		if (!userMapper.delUser(id)){
			dto.setStatus(SecurityResultEnum.ERROR_BAD_SQL.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_BAD_SQL.getMsgZH());

			log.info(SecurityResultEnum.ERROR_BAD_SQL.toString());
			return dto;
		}

		// 删除此user关联的role信息
		if (!userMapper.delRole2User(id)){
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
	public DTO updateUser(User user) {
		DTO dto = new ResultDTO();

		if (!userMapper.updateUser(user)){
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
	public DTO getUserInfo() {
		DTO dto = new ResultDTO();
		List<User> userInfoList = userMapper.getUserInfo();

		List<User> users = new ArrayList<>();
		for (User user : userInfoList){
			user.setRoleList(roleMapper.findRolesByUserId(user.getId()));
			users.add(user);
		}

		dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
		dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());
		dto.setData(users);
		log.info(SecurityResultEnum.SUCCESS.toString());
		return dto;
	}

	@Override
	public DTO getUserInfoByUserId(String id) {
		DTO dto = new ResultDTO();

		User user = userMapper.getUserInfoByUserId(id);

		if (user == null){
			dto.setStatus(SecurityResultEnum.ERROR_EMPTY_RESULT.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_EMPTY_RESULT.getMsgZH());

			log.error(SecurityResultEnum.ERROR_EMPTY_RESULT.toString());
			return dto;
		}

		user.setRoleList(roleMapper.findRolesByUserId(user.getId()));

		dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
		dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());
		dto.setData(user);

		log.info(SecurityResultEnum.SUCCESS.toString());
		return dto;
	}

	@Override
	public DTO userBindRole(Map<String, String> map) {
		DTO dto = new ResultDTO();

		// 判断用户是否绑定角色
		if (userMapper.hasUserBundRole(map)){
			dto.setStatus(SecurityResultEnum.ERROR_USER_HAS_BUND_ROLE.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_USER_HAS_BUND_ROLE.getMsgZH());

			log.error(SecurityResultEnum.ERROR_USER_HAS_BUND_ROLE.getMsgZH());
			log.error(SecurityResultEnum.ERROR_USER_HAS_BUND_ROLE.getMsgEN());
			return dto;
		}

		// 绑定角色
		if (!userMapper.userBindRole(map)){
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
	public DTO userUnbindRole(Map<String, String> map) {
		DTO dto = new ResultDTO();

		if (!userMapper.userUnbindRole(map)){

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


	/**
	 * 判断用户名是否存在
	 * @param username 用户名
	 * @return boolean
	 */
	private boolean isUserExist(String username){
		return userMapper.isUserExist(username) ? true : false;
	}
}
