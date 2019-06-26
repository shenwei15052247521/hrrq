package com.lanswon.core.bean.pojo;


import lombok.Data;

import java.time.LocalDateTime;

/**
 * 凭证实体类
 *
 * <p>
 *  序列号命名规则： YYYYMMDD+XXXXXX
 *  YYYYMMDD：打印凭证的当天日期
 *  对应数据库中表{@code ticket_record}
 * </p>
 *
 * @author Jaswine
 */
@Data
public class TicketRecord {

  /**
   * 凭证id
   */
  private String ticketSeqId;
  /**
   * 凭证序列号
   */
  private String ticketSeq;
  /**
   * 凭证类型
   * @see com.lanswon.core.enums.TickeTypeEnum
   */
  private int ticketType;
  /**
   * 凭证生成日期时间
   */
  private LocalDateTime ticketDateTime;

}
