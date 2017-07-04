package com.rep.core.special;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class DateUtil {
    private Date date;
    private int dayOfWeek;
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private final static SimpleDateFormat jsonFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    //    private final static List<Integer> months31 = Arrays.asList(0, 2, 4, 6, 7, 9, 11);
    private final static List<Integer> months30 = Arrays.asList(3, 5, 8, 10);

    private static boolean isLeap(Date date) {
        int year = date.getYear() + 1900;
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public static int dayOf(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static Date nextDate(Date date, int n) {
        return new Date(date.getTime() + 1000L * 60 * 60 * 24 * n);
    }

    public static Date nextDay(Date date) {
        return nextDate(date, 1);
    }

    public static Date nextWeek(Date date) {
        return nextDate(date, 7);
    }

    public static Date nextMonth(Date date) {
        if (date.getMonth() == 2) {
            if (isLeap(date)) {
                return nextDate(date, 29);
            } else {
                return nextDate(date, 28);
            }
        } else if (months30.contains(date.getMonth())) {
            return nextDate(date, 30);
        } else {
            return nextDate(date, 31);
        }
    }

    public static Date nextYear(Date date) {
        if (isLeap(date)) {
            return nextDate(date, 366);
        } else {
            return nextDate(date, 365);
        }
    }

    public static int daysBetweenDates(Date start, Date finish) {
        return (int) ((finish.getTime() - start.getTime()) / (1000L * 60 * 60 * 24) + 1);
    }

    public static Date getDateByWeekDay(Date start, int day) {
        int dayStart = dayOf(start);
        return nextDate(start, (7 - dayStart + day) % 7);
    }

    public static Date toDate(String stringDate) {
        try {
            return dateFormat.parse(stringDate);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String toString(Date date) {
        return dateFormat.format(date);
    }

    public DateUtil() {
    }

    public DateUtil(Date date, int dayOfWeek) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
