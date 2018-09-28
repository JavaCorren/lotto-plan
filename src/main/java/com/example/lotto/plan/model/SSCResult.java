package com.example.lotto.plan.model;

import lombok.Data;

/**
 * 时时彩开奖结果类
 * @author ZhangGR
 * @created on 2018/9/24
 **/
@Data
public class SSCResult {

    /**
     * 主键
     */
    private Long id;

    /**
     * 开奖结果
     */
    private String result;

    /**
     * 开奖期数
     */
    private String period;

    /**
     * 个位数字
     */
    private String unitDigitAttr;

    /**
     * 十位数字
     */
    private String tenDigitAttr;

    /**
     * 后三组合
     */
    private String lastThreeComposition;

    /**
     * 开奖日期
     */
    private String date;


}
