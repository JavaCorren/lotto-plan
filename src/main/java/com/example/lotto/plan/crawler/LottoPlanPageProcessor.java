package com.example.lotto.plan.crawler;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;

import static com.example.lotto.plan.rule.ExtractionEnumeration.CQ_SSC_UNIT_SOLO_PLAN;


/**
 * @author ZhangGR
 * @created on 2018/9/16
 **/
@Component
public class LottoPlanPageProcessor extends AbstractPageProcessor {

    @Override
    public void processPage(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        page.putField("author", page.getUrl().regex(CQ_SSC_UNIT_SOLO_PLAN.getAuth_Path()).toString());

        page.putField("latest", page.getHtml().$(CQ_SSC_UNIT_SOLO_PLAN.getLatest_Path()).get()
                .replaceAll("<span style=\"color:red;font-size:24px;font-weight: bold;\">","")
                .replaceAll("</span>","")
                .toString());

        page.putField("data", page.getHtml().$(CQ_SSC_UNIT_SOLO_PLAN.getData_Path()).get()
                .replaceAll(", ","")
                .replaceAll("<div class=\"date\">","")
                .replaceAll("\\n","")
                .replaceAll("\\r","")
                .replaceAll("\\t","")
                .replaceAll("\\s+","")
                .replaceAll("</div>","")
                .toString());

        page.putField("type", 1);
    }

}
