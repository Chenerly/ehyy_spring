package com.ehyy.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class Dateutils {
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String H3YUN_PATTERN = "yyyy-MM-dd H:mm:ss";

    public static final String DATE_WITH_ZRO_H_M_S = "yyyy-MM-dd 00:00:00";

    public static final String DATE_WITH_MAX_H_M_S = "yyyy-MM-dd 23:59:59";

    public static final String DATE_NO_SECOND_PATTERN = "yyyy-MM-dd HH:mm";

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String HOUR_AND_MINUTE = "HH:mm";

    public static final String DATE_SLASH_PATTERN = "yyyy/MM/d";

    public static final String DATE_NO_SPLIT_PATTERN = "yyyyMMddHHmmss";

    public static final String DATE_CHINESE_PATTERN = "MM月dd日";

    public static final String DATE_CHINESE_DAY_PATTERN = "d号";

    public static final String DATE_CHINESE_PATTERN_WITH_YEAR = "yyyy年MM月dd日";

    public static final String DATE_CHINESE_PATTERN_WITH_MONTH = "yyyy年MM月";
    public static final String DATE_CHINESE_PATTERN_WITH_MONT1H = "yyyy年M月";

    public static final String DATE_CHINESE_ALL_PATTERN = "yyyy年MM月dd日HH点mm分ss秒";

    public static String format(Date date) {
        return format(date, DEFAULT_PATTERN);
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static Date parse(String date) throws ParseException {
        return parse(date, DEFAULT_PATTERN);
    }

    public static Date parse(String date, String pattern) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.parse(date);
    }

    public static String unixTimeToSimpleDateString(final long unixTimeInMilliSecond, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(new Date(unixTimeInMilliSecond));
    }

    /**
     * 获取
     * @param date 需要是每个月的月初
     * @return
     */
    public static void getWeekOfMontAndWeekStartAndEnd(int weekNo, Date date, Map<Integer, WeekRange> map) {
        int week = week(date);
        Date lastMonthDate = lastMonthDate(date);
        if(null == map){
            WeekRange range = new WeekRange(date, date);
            map = new HashMap<>();
            map.put(weekNo, range);
        }else{
            WeekRange range = map.get(weekNo);
            if(null == range){
                range = new WeekRange(date);
            }
            range.setEnd(date);
            map.put(weekNo,range);
        }

        if(date.equals(lastMonthDate)){
            return ;
        }

        if(week == 0){
            weekNo++;
        }
        getWeekOfMontAndWeekStartAndEnd(weekNo, nextDate(date), map);
    }

    // 获取月初
    public static Date firstMonthDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    // 获取月末
    public static Date lastMonthDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }
    // 星期几
    public static int week(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    // 上个月
    public static Date lastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    // 下一天
    public static Date nextDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取距离当前日期前/后N天日期
     * @param date 当前日期
     * @param n 相距天数
     * @return
     */
    public static Date aroundDate(Date date, int n){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, n);
        return calendar.getTime();
    }

    // 月初时间
    public static Date beginningOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    // 月末时间
    public static Date endOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getBeginOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    public static Date getEndOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    public static void main(String[] args) throws Exception{
        Date date = new Date();
        System.out.print(week(date));
    }



    /**
     * 获取上一个月同一天
     * @param date
     * @return
     */
    public static Date lastMonthSameTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
        return cal.getTime();
    }





}
