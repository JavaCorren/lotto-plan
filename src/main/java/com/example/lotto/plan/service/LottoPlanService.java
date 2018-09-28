package com.example.lotto.plan.service;

import com.example.lotto.plan.mapper.LottoPlanMapper;
import com.example.lotto.plan.model.LottoPlan;
import com.example.lotto.plan.rule.ExtractionEnumeration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ZhangGR
 * @created on 2018/9/16
 **/
@Slf4j
@Service
public class LottoPlanService implements ILottoPlan{

    @Autowired
    private LottoPlanMapper lottoPlanMapper;

    /**
     * 保存开奖计划方案
     * @param data
     * @param type
     * @param date
     */
    @Override
    public void update(String latest, String data,  String date, Integer type) {

        if (type == null) {
            log.error("unknown lotto type");
            return;
        }

        ExtractionEnumeration e = ExtractionEnumeration.getPlanByValue(type);

        /**
         * 查询当天的计划
         */
        LottoPlan lottoPlan = lottoPlanMapper.select(type, date);
        Optional<LottoPlan> optionalPlan = Optional.ofNullable(lottoPlan)
                .map(plan -> {
                    plan.setData(data);
                    plan.setLatest(latest);
                    return plan;
                });


        //计划存在则更新
        if (optionalPlan.isPresent()) {
            lottoPlanMapper.update(optionalPlan.get());
            log.info("plan data updated...");

         //计划不存在则新建
        } else {
            lottoPlan = new LottoPlan();
            lottoPlan.setData(data);
            lottoPlan.setDate(date);
            lottoPlan.setLatest(latest);
            lottoPlan.setType(e.getType());
            lottoPlan.setName(e.getName());
            lottoPlanMapper.save(lottoPlan);
            log.info("plan data saved...");
        }

    }

}
