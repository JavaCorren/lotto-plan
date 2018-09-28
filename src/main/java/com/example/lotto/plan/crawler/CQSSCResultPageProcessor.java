package com.example.lotto.plan.crawler;

import com.example.lotto.plan.model.SSCResult;
import com.example.lotto.plan.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import us.codecraft.webmagic.Page;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * 获取重庆时时彩开奖记录的方法
 * @author ZhangGR
 * @created on 2018/9/24
 **/
@Slf4j
@Component
public class CQSSCResultPageProcessor extends AbstractPageProcessor {

    @Override
    public void processPage(Page page) {
        page.putField("results",page.getHtml().$("#mainArea div.lottery-results table tbody tr").all());
        page.putField("resultList", getResults(page.getHtml().$("#mainArea div.lottery-results table tbody tr").all()));
        page.putField("",null);
    }


    private List<SSCResult> getResults(List<String> stringList) {

        if (CollectionUtils.isEmpty(stringList)) {return null;}
        List<SSCResult> container = new ArrayList<>();

        for (String s:stringList) {
            List<SSCResult> results = getResults(s);
            container.addAll(results);
        }

        return container;
    }


    private List<SSCResult> getResults(String s) {

        if (StringUtils.isEmpty(s)) {return null;}

        //  https://blog.csdn.net/qy20115549/article/details/53556928?utm_source=copy JSOUP会自动将片段标签补全为html
        String content="<html>  <body> <table> <tbody>"+s+"</tbody> </table> </body> </html>";
        Document document = Jsoup.parse(content);

        //删除第一个tr节点（该节点只是表头）
        document.select("tr").remove(0);

        List<SSCResult> result = getResult(document);
        return result;
    }

    /**
     * 将document解析转化为result对象
     * @param document
     * @return
     */
    private List<SSCResult> getResult(Document document) {

        //  第一条tr里面的所有td记录
        Elements trList = document.select("tr");
        List<SSCResult> container = new ArrayList<>();

        for (Element element : trList) {

            Elements results = element.select("td");
            if (CollectionUtils.isEmpty(results)) {continue;}

            List<SSCResult> sscResultList = new ArrayList<>();

            //遍历 td ，7条一组
            for (int i = 0; i < 3; i++) {
                Element result1 = results.get(7*i);

                //获取开奖数字，若数字为空，则直接continue
                String win_number = result1.attr("data-win-number");
                if (StringUtils.isEmpty(win_number)) {continue;}

                String r1_date_period = "20" + result1.attr("data-period");
                String date = "";
                String period = r1_date_period.substring(r1_date_period.length() - 3);

                try {
                    int r1_length = r1_date_period.length();
                    date = DateUtils.parse(r1_date_period.substring(0,r1_length - 3));
                } catch (ParseException e) {
                    e.printStackTrace();
                    log.error("We have a parseException during our date parse attempt on data_win_number:" + win_number);
                }

                Element result1_digit_unit =results.get(7*i+2);
                Element result1_digit_diez = results.get(7*i+3);
                Element result1_digit_tres = results.get(7*i+4);

                String r1_digit_unit = result1_digit_unit.text();
                String r1_digit_diez = result1_digit_diez.text();
                String r1_digit_tres = result1_digit_tres.text();

                SSCResult sscResult1 = new SSCResult();
                sscResult1.setResult(win_number);
                sscResult1.setDate(date);
                sscResult1.setPeriod(period);
                sscResult1.setUnitDigitAttr(r1_digit_unit);
                sscResult1.setTenDigitAttr(r1_digit_diez);
                sscResult1.setLastThreeComposition(r1_digit_tres);
                sscResultList.add(sscResult1);
            }

            container.addAll(sscResultList);
        }

        return container;
    }

}
