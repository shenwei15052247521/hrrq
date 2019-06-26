package com.lanswon.core.bean.pojo;


import lombok.Data;

/**
 * 设备实体类
 *
 * 对应表{#device}
 *
 * @author Jaswine
 */
@Data
public class Device {

  /**
   * 设备id
   */
  private String deviceId;
  /**
   * 设备型号代码
   */
  private String deviceTypeCode;
  /**
   * 设备型号
   */
  private String deviceType;
  /**
   * 设备名称
   */
  private String deviceName;
  /**
   * 设备ip(默认0.0.0.0)
   */
  private String deviceIp;
  /**
   * 设备端口
   */
  private long devicePort;
  /**
   * 设备位置
   */
  private String deviceLocation;
  /**
   * 设备状态
   */
  private String status;
  /**
   * 设备状态码
   */
  private String statusCode;


}
