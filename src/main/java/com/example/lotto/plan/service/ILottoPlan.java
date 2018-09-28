package com.example.lotto.plan.service;

/**
 * @author ZhangGR
 * @created on 2018/9/16
 **/
public interface ILottoPlan {

    /**
     * 更新或添加彩票计划
     * @param data
     * @param date
     * @param type
     */
    void update(String latest, String data, String date, Integer type);
}
