package com.lanswon.util.utils;

import java.util.UUID;

/**
 * 生成UUID工具类
 * @author Jasmine
 */
public class UUIDUtil {

    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
