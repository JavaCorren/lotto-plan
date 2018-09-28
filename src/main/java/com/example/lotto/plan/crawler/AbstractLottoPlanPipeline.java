package com.example.lotto.plan.crawler;

import com.example.lotto.plan.service.LottoPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhangGR
 * @created on 2018/9/23
 **/
public abstract class AbstractLottoPlanPipeline implements Pipeline {

    @Autowired
    private LottoPlanService lottoPlanService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        if (resultItems == null) {return;}
        if (resultItems.get("data") == null) {return;}

        String latest = resultItems.get("latest").toString();
        String data = resultItems.get("data").toString();
        Integer type = resultItems.get("type");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);

        lottoPlanService.update(latest, data,  formattedDate, type);
    }
}
