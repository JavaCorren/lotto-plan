package com.example.lotto.plan.rule;

import lombok.Getter;

/**
 * @author ZhangGR
 * @created on 2018/9/18
 **/
public enum ExtractionEnumeration {

    //重庆时时彩独胆个位计划枚举
    CQ_SSC_UNIT_SOLO_PLAN("https://www.310040.com/data.php?ac=plan","div[align='center'] div.date","div[align='center'] span:nth-child(3)",1,"重庆时时彩"),

    //PK10冠军独胆计划枚举
    PK_10_CHAMPION_SOLO_PLAN("https://www.310040.com/data1.php?ac=bjpk","div[align='center'] div.date","div[align='center'] span:nth-child(4)",2,"北京PK10");

    @Getter
    private String auth_Path;

    /**
     * 计划历史
     */
    @Getter
    private String data_Path;

    /**
     * 最新计划
     */
    @Getter
    private String latest_Path;

    /**
     * 彩种类型
     */
    @Getter
    private Integer type;

    /**
     * 彩种名称
     */
    @Getter
    private String name;

    ExtractionEnumeration(String auth_Path, String data_Path, String latest_Path, Integer type, String name) {
        this.data_Path = data_Path;
        this.latest_Path = latest_Path;
        this.auth_Path = auth_Path;
        this.type = type;
        this.name = name;
    }

    /**
     * 根据type的值来获取对应的枚举
     * @param value
     * @return
     */
    public static ExtractionEnumeration getPlanByValue(Integer value){

        if (value == null) {
            return null;
        }

        for (ExtractionEnumeration enumeration : ExtractionEnumeration.values()) {
            if (enumeration.getType().equals(value)) {
                return enumeration;
            }
        }

        return null;
    }
}
