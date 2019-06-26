package com.lanswon.auth.mapper;

import com.lanswon.auth.bean.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Jaswine
 */
@Repository
public interface UserMapper {

	User login(String username);

	boolean addUser(@Param("user") User user);

	boolean delUser(String id);

	boolean delRole2User(String id);

	boolean updateUser(@Param("user") User user);

	List<User> getUserInfo();

	User getUserInfoByUserId(String id);

	boolean userBindRole(@Param("map") Map<String, String> map);

	boolean userUnbindRole(@Param("map") Map<String, String> map);

	boolean isUserExist(String username);

	boolean hasUserBundRole(@Param("map") Map<String, String> map);
}
