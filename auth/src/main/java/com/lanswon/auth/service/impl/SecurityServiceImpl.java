package com.lanswon.auth.service.impl;

import com.lanswon.auth.bean.pojo.Permission;
import com.lanswon.auth.jwt.Claim;
import com.lanswon.auth.jwt.Jwtoken;
import com.lanswon.auth.mapper.PermissionMapper;
import com.lanswon.auth.mapper.RoleMapper;
import com.lanswon.auth.mapper.UserMapper;
import com.lanswon.auth.bean.pojo.Role;
import com.lanswon.auth.bean.pojo.User;
import com.lanswon.auth.bean.dto.ResultDTO;
import com.lanswon.auth.security.SecurityResultEnum;
import com.lanswon.auth.service.SecurityService;
import com.lanswon.util.codec.EncodingEnum;
import com.lanswon.util.crypto.Md5;
import com.lanswon.web.dto.DTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限ServiceImpl
 * @author Jaswine
 */
@Service
@Slf4j
public class SecurityServiceImpl implements SecurityService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private PermissionMapper permissionMapper;


	@Override
	public DTO login(User user) throws Exception {
		ResultDTO dto = new ResultDTO();

		User userInfo = userMapper.login(user.getUsername());

		// 判断用户是否存在
		if (userInfo == null){
			dto.setStatus(SecurityResultEnum.ERROR_NO_USER.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_NO_USER.getMsgZH());

			log.error(SecurityResultEnum.ERROR_NO_USER.toString());
			return dto;
		}

		// 判断密码是否正确
		if (!Md5.MD5Encode(user.getPassword(),EncodingEnum.UTF_8,true).equals(userInfo.getPassword())){
			dto.setStatus(SecurityResultEnum.ERROR_INCORRECT_PASSWORD.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_INCORRECT_PASSWORD.getMsgZH());

			log.error(SecurityResultEnum.ERROR_INCORRECT_PASSWORD.toString());
			return dto;
		}

		// 查找用户的角色
		List<Role> roles = roleMapper.findRolesByUserId(userInfo.getId());
		if (roles.isEmpty()){
			dto.setStatus(SecurityResultEnum.ERROR_EMPTY_ROLE.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_EMPTY_ROLE.getMsgZH());

			log.error(SecurityResultEnum.ERROR_EMPTY_ROLE.toString());
			return dto;
		}else {
			userInfo.setRoleList(roles);
		}

		dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
		dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());
		dto.setData(userInfo);

		// 生成token
		Claim<User> claim = new Claim<>();
		claim.setSubject(userInfo);
		String token = Jwtoken.createToken(claim);
		dto.setToken(token);

		log.info("[SecurityServiceImpl]登录成功，token为:{"+token+"}");

		return dto;
	}

	@Override
	public DTO logout() {
		return null;
	}

	@Override
	public DTO index() {
		DTO dto = new ResultDTO();

		List<Permission> menus = permissionMapper.index();

		if (menus.isEmpty()){
			dto.setStatus(SecurityResultEnum.ERROR_EMPTY_RESULT.getCode());
			dto.setMsg(SecurityResultEnum.ERROR_EMPTY_RESULT.getMsgZH());
			return dto;
		}

		dto.setStatus(SecurityResultEnum.SUCCESS.getCode());
		dto.setMsg(SecurityResultEnum.SUCCESS.getMsgZH());
		dto.setData(menus);

		return dto;
	}

}
