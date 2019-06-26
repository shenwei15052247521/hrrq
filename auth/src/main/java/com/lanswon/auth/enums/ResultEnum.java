package com.lanswon.auth.enums;

import lombok.Getter;
import lombok.ToString;

@ToString
public enum ResultEnum {


    /**
     * 成功
     */
    SUCCESS(200, "SUCCESS"),
    /**
     * 错误
     */
    ERROR(400, "错误"),
    /**
     * SQl错误
     */
    SQLERROR(401, "SQL错误，请检查SQL"),
    /**
     * 参数传入错误
     */
    PARAMS_ERROR(402, "您传入的参数不对"),
    /**
     * 结果为空
     */
    EMPTY_RESULT(403, "结果为空"),
    /**
     * 没带token
     */
    ERROR_NO_TOKEN(404, "没有token..."),
    /**
     * token错误
     */
    ERROR_INCORRECT_TOKEN(405, "token错误...");




    /**
     * 状态码
     */
    @Getter
    private int code;
    /**
     * 状态信息
     */
    @Getter
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
