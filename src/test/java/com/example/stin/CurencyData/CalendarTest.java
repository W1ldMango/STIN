package com.example.stin.CurencyData;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

class CalendarTest {

    @Test
    void testGetThursdayDate() {
        Calendar calendar = new Calendar();
        LocalDate date1 = LocalDate.now();
        LocalDate lastThursday = date1.with(DayOfWeek.THURSDAY).minusWeeks(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        // Act
        String actualThursdayDate = calendar.getThursdayDate();

        assertEquals(lastThursday.format(formatter), actualThursdayDate);
    }

    @Test
    void testGetYesterdayDate() {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.add(java.util.Calendar.DATE, -1);
        int yesterday = calendar.get(java.util.Calendar.DATE);
        int month = calendar.get(java.util.Calendar.MONTH) + 1;
        String yesterdayString = yesterday + "." + month + "." + 2023;

        assertEquals(yesterdayString, (new Calendar()).getYesterdayDate());

    }

    @Test
    void isWeekend() {
        Calendar calendar = new Calendar();
        Date date = new Date();
        int day = date.getDay();
        if (day == 0 || day == 6) {
            assertEquals(true, calendar.isWeekend());
        } else {
            assertEquals(false, calendar.isWeekend());
        }

    }


}

