package com.lanswon.core.bean.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * 用户DTO
 * @author Jaswine
 */
public class UserDTO {

	/** 用户id */
	@Getter
	@Setter
	private String userId;
	/** 用户名 */
	@Getter
	@Setter
	private String userName;
	/** 身份证号 */
	@Getter
	@Setter
	private String idCard;
	/** 性别 */
	@Getter
	@Setter
	private String sex;
	/** 备注 */
	@Getter
	@Setter
	private String remark;
	/** 部门 */
	@Getter
	@Setter
	private String departmentId;
	/** 用户类型 */
	@Getter
	@Setter
	private int userType;
}
