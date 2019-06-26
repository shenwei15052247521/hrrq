package com.lanswon.core.bean.pojo;


import lombok.Data;

/**
 * 用户信息实体类
 * <p>
 *     数据库中表{@code acct_user}对应的实体类
 * </p>
 * @author Jaswine
 */
@Data
public class User {

  /**
   * 用户ID
   */

  private String userId;
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
   * 用户部门
   */
  private String departmentId;
  /**
   * 性别
   */
  private String sex;
  /**
   * 备注
   */
  private String remark;
  /**
   * 人脸Id
   */
  private String faceId;
  /** 用户类型 */
  private int userType;

}
