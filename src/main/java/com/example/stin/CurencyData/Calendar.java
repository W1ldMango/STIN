package com.example.stin.CurencyData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
    * This class is part of the Central Bank of Czech Republic API.
 */
@SuppressWarnings("deprecation")
public class Calendar {

    /**
        * This method is used to get if today is a weekend.
     */
    public boolean isWeekend() {
        Date date = new Date();
        int day = date.getDay();
        if (day == 0 || day == 6) {
            return true;
        } else {
            return false;
        }
    }

    /**
        * This method is used to get information of last thursday.
        * To check last CNB data update on weekends.
     */
    public String getThursdayDate(){
        LocalDate date1 = LocalDate.now();
        LocalDate lastThursday = date1.with(DayOfWeek.THURSDAY).minusWeeks(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return lastThursday.format(formatter);
    }

    /**
     * This method is used to get information of today.
     * @return - today's date
     */
    public String getNow() {
        Date date = new Date();
        int dayOfMonth = date.getDate();
        int month = date.getMonth() + 1;
        return dayOfMonth + "." + month + "." + 2023;
    }

    /**
        * This method is used to get information of yesterday.
        * To check currency change in last 24 hours.
     */
    public String getYesterdayDate() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.add(java.util.Calendar.DATE, -1);
        int yesterday = cal.get(java.util.Calendar.DATE);
        int month = cal.get(java.util.Calendar.MONTH) + 1;
        return yesterday + "." + month + "." + 2023;
    }

    /**
        * This method is used to get information is today monday.
        * To complete comparing of currency change in monday and last working day.
     */

    public boolean isMonday() {
        return new Date().getDay() == 1;

    }



}
