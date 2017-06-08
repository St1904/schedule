package com.rep.core.special;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class DateTranslator {
    private Date date;
    private int dayOfWeek;
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static int dayOf(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static Date nextDate(Date date, int n) {
        return new Date(date.getTime() + 1000L*60*60*24*n);
    }

    public static int daysBetweenDates(Date start, Date finish) {
        return (int) ((finish.getTime() - start.getTime())/(1000L*60*60*24) + 1);
    }

    public static Date getDateByWeekDay(Date start, int day) {
        int dayStart = dayOf(start);
        return nextDate(start, (7 - dayStart + day) % 7);
    }

    public static Date strToDate(String stringDate) {
        try {
            return simpleDateFormat.parse(stringDate);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String dateToStr(Date date) {
        return simpleDateFormat.format(date);
    }

    public DateTranslator() {
    }

    public DateTranslator(Date date, int dayOfWeek) {
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
