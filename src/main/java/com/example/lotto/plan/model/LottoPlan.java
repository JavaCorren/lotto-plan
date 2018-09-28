package com.example.lotto.plan.model;

import lombok.Data;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * @author ZhangGR
 * @created on 2018/9/16
 **/

@Data
@TargetUrl("https://www.310040.com/data.php?ac=plan")
public class LottoPlan {

    /**
     * 记录id
     */
    private Long id;

    /**
     * 日期
     */
    @ExtractBy(value = "div[align='center'] latest", type = ExtractBy.Type.Css)
    private String date;

    /**
     * 计划数据
     */
    @ExtractBy(value = "div[align='center'] div.date", type = ExtractBy.Type.Css)
    private String data;

    /**
     * 彩种名称
     */
    private String name;

    /**
     * 彩种类型
     */
    private Integer type;

    /**
     * 最近计划
     */
    private String latest;

}
