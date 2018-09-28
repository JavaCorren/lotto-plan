package com.example.lotto.plan.crawler;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author ZhangGR
 * @created on 2018/9/18
 **/
public abstract class AbstractPageProcessor implements PageProcessor {

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(3000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");

    @Override
    public void process(Page page) {
       processPage(page);
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public abstract void processPage(Page page);

}
