package com.cc.smartx.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.cnblogs.com/qingyunfc/p/10236734.html
 * @description:
 * @Author chenlipeng
 * @Date 2020-06-21
 */
public class LocalDateUtil {

    public static void test() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = localDate.minusMonths(1);
        System.out.println(localDate);
        System.out.println(localDate2);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        System.out.println("========");
        List<String> rebateTimeList = new ArrayList<String>();

        String[]    quarter = {"Q1" ,"Q2" ,"Q3", "Q4"};
        LocalDate current = LocalDate.now();
        int  currentQuarterIndex =    current.getMonthValue();
        currentQuarterIndex = (currentQuarterIndex-1)/3;
        String currentQuarter = current.getYear()+"-"+quarter[currentQuarterIndex];

        LocalDate threeMonthsAgo = current.minusMonths(3);
        int  lastQuarterIndex =    threeMonthsAgo.getMonthValue();
        lastQuarterIndex = (lastQuarterIndex-1)/3;
        String lastQuarter = threeMonthsAgo.getYear()+"-"+quarter[lastQuarterIndex];
        rebateTimeList.add(lastQuarter);
        rebateTimeList.add(currentQuarter);
    }

}
