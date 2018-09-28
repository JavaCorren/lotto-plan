package com.example.lotto.plan.crawler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import static com.example.lotto.plan.rule.ExtractionEnumeration.CQ_SSC_UNIT_SOLO_PLAN;
import static com.example.lotto.plan.rule.ExtractionEnumeration.PK_10_CHAMPION_SOLO_PLAN;

/**
 * @author ZhangGR
 * @created on 2018/9/16
 **/
@Slf4j
@Component
public class Spiders {

    @Autowired
    private LottoPlanPageProcessor lottoPlanPageProcessor;

    @Autowired
    private LottoPlanRawPipeline lottoPlanRawPipeline;

    @Autowired
    private PK10PlanRawPipeline pk10PlanRawPipeline;

    @Autowired
    private PK10PlanPageProcessor pk10PlanPageProcessor;

    @Autowired
    private CQSSCResultPageProcessor cqsscResultPageProcessor;

    /**
     * @should test
     */
//    @Scheduled(fixedRate = 60000)
    public void crawlForSSC() {

        log.info("SSC Spider is crawling now...");

        Spider.create(lottoPlanPageProcessor)
                .addUrl(CQ_SSC_UNIT_SOLO_PLAN.getAuth_Path())
                .addPipeline(lottoPlanRawPipeline)
                .thread(2).run();
    }

    /**
     * @should test
     */
//    @Scheduled(fixedRate = 60000)
    public void crawlForPK10() {

        log.info("PK 10 Spider is crawling now...");

        Spider.create(pk10PlanPageProcessor)
                .addUrl(PK_10_CHAMPION_SOLO_PLAN.getAuth_Path())
                .addPipeline( pk10PlanRawPipeline)
                .thread(2).run();

    }

    /**
     * @should test
     */
    @Scheduled(fixedRate = 600000)
    public void crawlForSSCResults() {

        log.info("PK 10 Spider is crawling now...");

        Spider.create(cqsscResultPageProcessor)
                .addUrl("http://caipiao.163.com/award/cqssc/20180924.html")
//                .addPipeline( pk10PlanRawPipeline)
                .thread(2).run();

    }
}
