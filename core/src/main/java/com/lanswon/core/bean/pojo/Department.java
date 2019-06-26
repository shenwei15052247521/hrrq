package com.lanswon.core.bean.pojo;


import lombok.Data;

/**
 * 政府部门实体类
 *
 * 对应表{@code department}
 *
 * @author Jaswine
 */
@Data
public class Department {

  /**
   * 部门id
   */
  private String departId;
  /**
   * 部门名称
   */
  private String departName;
  /**
   * 部门人数
   */
  private String departNum;
  /**
   * 部门地址
   */
  private String departLocation;
  /**
   * 部门联系方式
   */
  private String departTel;


}
