package com.rep.core.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private final static SimpleDateFormat jsonFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private final static List<Integer> months30 = Arrays.asList(3, 5, 8, 10);

    private static boolean isLeap(Date date) {
        int year = date.getYear() + 1900;
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
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

    public static boolean afterOrEqual(Date first, Date second) {
        return first.after(second) || first.getTime() == second.getTime();
    }

    public static boolean beforeOrEqual(Date first, Date second) {
        return first.before(second) || first.getTime() == second.getTime();
    }

    public static Date toDate(String stringDate) {
        try {
            return dateFormat.parse(stringDate);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String toString(Date date) {
        return (date == null ? null : dateFormat.format(date));
    }
}
