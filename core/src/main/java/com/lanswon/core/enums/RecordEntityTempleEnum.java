package com.lanswon.core.enums;


import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 流水导出属性enum
 * @Author sw
 * @Date 2018/7/28 15:55
 */
public enum RecordEntityTempleEnum {

    RECORDTIME("recordTime", "交易日期", true),
    DEPARTMENT("department", "用户部门", true),
    USERNAME("userName", "用户姓名", true),
    TYPT("typt", "交易类型", true),
    TYPE("type", "交易方式", true),
    BFBALANCE("bfBalance", "交易前余额(元)", true),
    BALANCE("balance", "交易金额(元)", true),
    AFBALANCE("afBalance", "交易后金额(元)", true);





    /**
     * 对应的方法名
     */
    private String functionName;
    /**
     * 中文名
     */
    private String chineseName;
    /**
     * excel中是否有该属性。true：有改属性；false：无改属性
     */
    private Boolean isExcelProperty;

    /**
     * 以中文名为key，MemberBasePropertyEnum为value的map集合
     */
    private static Map<String, RecordEntityTempleEnum> chineseNameEnumMap = new HashMap<>();

    /**
     * 静态代码块，初始化chineseNameEnumMap
     */
    static {
        for (RecordEntityTempleEnum memberBasePropertyEnum : EnumSet.allOf(RecordEntityTempleEnum.class)) {
            chineseNameEnumMap.put(memberBasePropertyEnum.getChineseName(), memberBasePropertyEnum);
        }
    }

    /**
     * 根据excel名称获取方法名称
     * @param chineseName
     * @return
     */
    public static String getFunctionNameByChineseName(String chineseName) {
        RecordEntityTempleEnum memberBasePropertyEnum = chineseNameEnumMap.get(chineseName);
        if (null == chineseNameEnumMap.get(chineseName)) {
            return StringUtils.EMPTY;
        }
        return memberBasePropertyEnum.getFunctionName();
    }

    /**
     * 根据中文名检查是否是基础属性
     * @param chineseName
     * @return
     */
    public static Boolean checkChineseNameIsExist(String chineseName) {
        return chineseNameEnumMap.keySet().contains(chineseName);
    }

    RecordEntityTempleEnum(String functionName, String chineseName, Boolean isExcelProperty) {
        this.functionName = functionName;
        this.chineseName = chineseName;
        this.isExcelProperty = isExcelProperty;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public Boolean getExcelProperty() {
        return isExcelProperty;
    }

    public void setExcelProperty(Boolean excelProperty) {
        isExcelProperty = excelProperty;
    }
}
