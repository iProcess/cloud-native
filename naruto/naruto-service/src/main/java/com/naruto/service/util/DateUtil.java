package com.naruto.service.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DateUtil {
    /**
     * 一天的毫秒数
     */
    public static final long MILLS_DAY = 1000L * 60L * 60L * 24L;
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String MM_DD = "MM-dd";

    /**
     * 字符类型转换为时间类型
     * @param date
     * @return
     */
    public static Date parseDate(String date, String parsePattern){
        try {
            return DateUtils.parseDate(date, parsePattern);
        } catch (ParseException e) {
            log.error("parseDate error:", e);
        }
        return null;
    }

    public static String getYearWeekStr(String date, String parsePattern){
        Calendar calendarWeek = Calendar.getInstance();
        calendarWeek.setFirstDayOfWeek(Calendar.MONDAY);
        calendarWeek.setMinimalDaysInFirstWeek(4);
        calendarWeek.setTime(parseDate(date, parsePattern));
        calendarWeek.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        Integer year = calendarWeek.get(Calendar.YEAR);
        int weekOfYear = calendarWeek.get(Calendar.WEEK_OF_YEAR);
        String weekOfYearStr = String.format("%02d", weekOfYear);
        return year + weekOfYearStr;
    }

    public static void main(String[] args) {
        String date = "2020-01-06";
        String yearWeek = DateUtil.getYearWeekStr(date, DateUtil.YYYY_MM_DD);
        System.out.println(yearWeek);
        String year = yearWeek.substring(0, 4);
        System.out.println(year);
        String week = yearWeek.substring(4, 6);
        System.out.println(week);

    }

}
