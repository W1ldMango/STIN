package com.example.stin.CurencyData;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
    * This class is part of the Central Bank of Czech Republic API.
 */
@Service
public class CurrencyChange {

    /**
        * Define a new object of CNBData class to get access to the methods.
     */
    private static CNBData cnbData = new CNBData();
    private static Calendar Calendar = new Calendar();

    /**
        * This method is used to get the changes of the EUR currency.
     */
    public Double euroChanges() {
        String currency = cnbData.SortCurrencyData(cnbData.getCurrencyData(cnbData.getURLFromDate(Calendar.getNow())), "EUR").split("\\|")[4].replace(",", ".");
        String oldCurrency;
        if (Calendar.isWeekend() || Calendar.isMonday()) {
            oldCurrency = cnbData.SortCurrencyData(cnbData.getCurrencyData(cnbData.getURLFromDate(Calendar.getThursdayDate())), "EUR").split("\\|")[4].replace(",", ".");
        } else {
            oldCurrency = cnbData.SortCurrencyData(cnbData.getCurrencyData(cnbData.getURLFromDate(Calendar.getYesterdayDate())), "EUR").split("\\|")[4].replace(",", ".");
        }
        double changes = (Double.parseDouble(currency) - Double.parseDouble(oldCurrency)) / Double.parseDouble(oldCurrency) * 100;
        return Math.round(changes * 100.0) / 100.0;
    }

    /**
        * This method is used to get the changes of the USD currency.
     */
    public Double usdChanges() {
        String currency = cnbData.SortCurrencyData(cnbData.getCurrencyData(cnbData.getURLFromDate(Calendar.getNow())), "USD").split("\\|")[4].replace(",", ".");
        String oldCurrency;
        if (Calendar.isWeekend() || Calendar.isMonday()) {
            oldCurrency = cnbData.SortCurrencyData(cnbData.getCurrencyData(cnbData.getURLFromDate(Calendar.getThursdayDate())), "USD").split("\\|")[4].replace(",", ".");
        } else {
            oldCurrency = cnbData.SortCurrencyData(cnbData.getCurrencyData(cnbData.getURLFromDate(Calendar.getYesterdayDate())), "USD").split("\\|")[4].replace(",", ".");
        }
        double changes = (Double.parseDouble(currency) - Double.parseDouble(oldCurrency)) / Double.parseDouble(oldCurrency) * 100;
        return Math.round(changes * 100.0) / 100.0;
    }

    /**
        * This method is used to get the changes of the GBP currency.
     */
    public Double gbpChanges() {
        String currency = cnbData.SortCurrencyData(cnbData.getCurrencyData(cnbData.getURLFromDate(Calendar.getNow())), "GBP").split("\\|")[4].replace(",", ".");
        String oldCurrency;
        if (Calendar.isWeekend() || Calendar.isMonday()) {
            oldCurrency = cnbData.SortCurrencyData(cnbData.getCurrencyData(cnbData.getURLFromDate(Calendar.getThursdayDate())), "GBP").split("\\|")[4].replace(",", ".");
        } else {
            oldCurrency = cnbData.SortCurrencyData(cnbData.getCurrencyData(cnbData.getURLFromDate(Calendar.getYesterdayDate())), "GBP").split("\\|")[4].replace(",", ".");
        }
        double changes = (Double.parseDouble(currency) - Double.parseDouble(oldCurrency)) / Double.parseDouble(oldCurrency) * 100;
        return Math.round(changes * 100.0) / 100.0;
    }


}
