package com.example.lotto.plan.crawler;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;

import static com.example.lotto.plan.rule.ExtractionEnumeration.PK_10_CHAMPION_SOLO_PLAN;


/**
 * @author ZhangGR
 * @created on 2018/9/21
 **/
@Component
public class PK10PlanPageProcessor extends AbstractPageProcessor {

    @Override
    public void processPage(Page page) {

        // 部分二：定义如何抽取页面信息，并保存下来

        page.putField("latest", page.getHtml().$(PK_10_CHAMPION_SOLO_PLAN.getLatest_Path()).get()
                .replaceAll("<span style=\"color:red;font-size:24px;font-weight: bold;\">","")
                .replaceAll("</span>","")
                .toString());

        page.putField("data", page.getHtml().$(PK_10_CHAMPION_SOLO_PLAN.getData_Path()).get()
                .replaceAll(", ","")
                .replaceAll("<div class=\"date\">","")
                .replaceAll("\\n","")
                .replaceAll("\\r","")
                .replaceAll("\\t","")
                .replaceAll("\\s+","")
                .replaceAll("</div>","")
                .toString());

        page.putField("type",2);
    }
}
