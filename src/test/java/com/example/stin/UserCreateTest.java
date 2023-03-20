package com.example.stin;

import com.example.stin.CurencyData.CNBData;
import com.example.stin.CurencyData.Calendar;
import com.example.stin.CurencyData.CurrencyChange;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Date;

public class UserCreateTest {



    public static void main(String[] args) throws MalformedURLException, ParseException {
//        EmailController emailController = new EmailController();
//        emailController.sendEmail(new EmailDetails("justfoxel@gmail.com", "Hello", "Hello"));
        CNBData cnbData = new CNBData();
        Date date = new Date();
//        System.out.println(cnbData.getCurrencyData());
//        System.out.println(cnbData.getActualCurrencyURL(date, false));
//        System.out.println(cnbData.isDataActual());
//        System.out.println(cnbData.getEUR());
        Calendar Calendar = new Calendar();
        CurrencyChange getCurrencyChanges = new CurrencyChange();
//        System.out.println(getCurrencyChanges.getLastWorkDay());
//        System.out.println(cnbData.getUSD());
//        System.out.println(cnbData.getLastWorkDay());
//        System.out.println(cnbData.euroChanges());
//        System.out.println(Calendar.getThursdayDate());
//        System.out.println(Calendar.getYesterdayDate());
        System.out.println(getCurrencyChanges.euroChanges());



    }

}
