package com.lanswon.core.bean.pojo;


import lombok.Data;

/**
 * 充值记录实体类
 * <p>
 *     对应数据库中表{@code record_load}
 * </p>
 * @author Jaswine
 */
@Data
public class RecordLoad {

  /**
   * 充值记录id
   */
  private String recordId;
  /**
   * 账户id
   */
  private String recordAcctId;
  /**
   * 充值金额
   */
  private double recordLoad;
  /**
   * 账户充值前余额
   */
  private double recordBfLoad;
  /**
   * 账户充值后余额
   */
  private double recordAfLoad;
  /**
   * 充值日期时间(yyyy-mm-dd)
   */
  private java.sql.Timestamp recordLoadDateTime;
  /**
   * 充值设备id
   */
  private String recordLoadDeviceid;
  /**
   * 充值途径
   * @see com.lanswon.core.enums.MoneyTypeEnum
   */
  private int recordLoadType;
  /**
   * 系统用户id(操作人员id)
   */
  private String recordSysuserId;
  /**
   * 凭证序列号
   */
  private String recordTicketSeq;

}
