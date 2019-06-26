package com.lanswon.core.enums;


import lombok.Getter;
import lombok.Setter;

/**
 * 用户类型Enum
 *  <p>
 *      用户类型不同账户有效期不同
 *  </p>
 * @author Jaswine
 */
public enum UserTypeEnum {

    /** 临时用户 */
    USER_TEMP(1,"临时用户"),
    /** 正式用户 */
    USER_OFFICIAL(2,"正式用户");

    /** 编码 */
    @Getter
    @Setter
    private int code;
    /** 用户类型 */
    @Getter
    @Setter
    private String userType;

    UserTypeEnum(int code,String userType){
        this.code = code;
        this.userType = userType;
    }
}
