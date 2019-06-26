package com.lanswon.core.bean.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * 用户相关传输对象
 * <p>
 *     以用户为中心，封装用户拥有的相关属性。
 *     对应数据库中{@code userInfo}视图
 * </p>
 * @author Jaswine
 */
@Data
public class UserInfoVO {

	/*====用户的个人信息====*/
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 账户ID
	 */
	private String acctId;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 用户身份证号
	 */
	private String idCard;
	/**
	 * 市民卡号
	 */
	private String smkNo;
	/**
	 * 性别
	 */
	private String sex;
	/** 用户类型代码 */
	private int userTypeCode;
	/** 用户类型 */
	private String userType;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 人脸id
	 */
	private String faceId;
	/**
	 * 人脸Url
	 */
	private String faceUrl;
	/**
	 * 用户部门Id
	 */
	private String deptId;
	/**
	 * 用户部门
	 */
	private String deptName;
	/**
	 * 账户余额(十进制，以分为单位)
	 */
	private double balance;
	/**
	 * 开户时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date openDate;
	/**
	 * 启用时间(默认和开户时间相同)
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date startDate;
	/**
	 * 账户有效时间(默认100年,同时也可以指定;如：短期工作)
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date endDate;
	/**
	 * 账户状态id
	 */
	private String statusId;
	/**
	 * 账户状态
	 */
	private String status;


}


