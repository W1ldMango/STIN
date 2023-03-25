package com.example.stin.CurencyData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public Date getThursdayDate(){
        Date date = new Date();
        int day = date.getDay();
        int dayOfMonth = date.getDate();
        int month = date.getMonth() + 1;
        int year = date.getYear();
        int thursday = 0;
        switch (day) {
            case 0:
                thursday = dayOfMonth - 3;
                break;
            case 1:
                thursday = dayOfMonth - 4;
                break;
            case 2:
                thursday = dayOfMonth - 5;
                break;
            case 3:
                thursday = dayOfMonth - 6;
                break;
            case 4:
                thursday = dayOfMonth - 7;
                break;
            case 5:
                thursday = dayOfMonth - 1;
                break;
            case 6:
                thursday = dayOfMonth - 2;
                break;
        }
        String thursdayString = thursday + "." + month + "." + 2023;
        Date format = null;
        try {
            format = new SimpleDateFormat("dd.MM.yyyy").parse(thursdayString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format;
    }

    /**
        * This method is used to get information of yesterday.
        * To check currency change in last 24 hours.
     */
    public Date getYesterdayDate() {
        Date date = new Date();
        int day = date.getDay();
        int dayOfMonth = date.getDate();
        int month = date.getMonth();
        int year = date.getYear();
        int yesterday = 0;
        switch (day) {
            case 1:
                yesterday = dayOfMonth - 1;
                break;
            case 2:
                yesterday = dayOfMonth - 2;
                break;
            case 3:
                yesterday = dayOfMonth - 3;
                break;
            case 4:
                yesterday = dayOfMonth - 4;
                break;
            case 5:
                yesterday = dayOfMonth - 5;
                break;
            case 6:
                yesterday = dayOfMonth - 6;
                break;
            case 7:
                yesterday = dayOfMonth - 7;
                break;
        }
        String yesterdayString = yesterday + "." + month + "." + 2023;
        Date format = null;
        try {
            format = new SimpleDateFormat("dd.MM.yyyy").parse(yesterdayString);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format;
    }

    /**
        * This method is used to get information is today monday.
        * To complete comparing of currency change in monday and last working day.
     */

    public boolean isMonday() {
        if (new Date().getDay() == 1) {
            return true;
        } else {
            return false;
        }

    }



}
