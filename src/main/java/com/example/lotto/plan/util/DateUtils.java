package com.example.lotto.plan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ZhangGR
 * @created on 2018/9/24
 **/
public class DateUtils {

    /**
     * 转化日期
     * @param date
     * @return
     * @throws ParseException
     */
    public static String parse(String date) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date parsed = simpleDateFormat.parse(date);
        SimpleDateFormat anotherFormat = new SimpleDateFormat("yyyy-MM-dd");
        return anotherFormat.format(parsed);
    }
}
