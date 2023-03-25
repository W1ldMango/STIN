package com.example.stin.CurencyData;

import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
    * This class is part of the Central Bank of Czech Republic API.
 */


public class CNBData {

    /**
        * Define a url when we check the currency data.
     */
    private static final String URL = "https://www.cnb.cz/cs/financni-trhy/devizovy-trh/kurzy-devizoveho-trhu/kurzy-devizoveho-trhu/denni_kurz.txt?date=";

    /**
        * This method is used to get the url of the new currency data.
        * @param date - date of date we want to check
     */
    public String getURLFromDate(Date date) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        return URL+dateFormat.format(date);
    }

    /**
        * This method is used to get the currency data from the url.
        * @param DateURL - url of the currency data
     */
    public List<String> getCurrencyData(String DateURL) {
        URL url = null;
        URLConnection urlConnection = null;
        BufferedReader in = null;
        try {
            url = new URL(DateURL);
            urlConnection = url.openConnection();
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        String inputLine;
        List<String> currencyData = new ArrayList<>();
        try {
            while ((inputLine = in.readLine()) != null) {
                currencyData.add(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currencyData;
    }

    /**
        * This method is used to sort the currency data.
        * @param currencyData - currency data from the url
        * @param currency - currency we want to check
     */

    public String SortCurrencyData(List<String> currencyData, String currency) {
        for (String line : currencyData) {
            switch (currency) {
                case "USD":
                    if (line.contains("USD")) {
                        return(line); // USD data
                    }
                    break;
                case "EUR":
                    if (line.contains("EUR")) {
                        return(line); // EUR data
                    }
                    break;
                case "GBP":
                    if (line.contains("GBP")) {
                        return(line); // GBP data
                    }
                    break;
            }
        }
        return null;
    }

    /**
        * This method is used to get the USD currency data.
        * @Scheduled(cron = "0 0 13-15 * * *") - this method is called every day from 13:00 to 15:00
     */
    @Scheduled(cron = "0 0 13-15 * * *")
    public String getUSD() {
        return (SortCurrencyData(getCurrencyData(getURLFromDate(new Date())), "USD").split("\\|")[4]).replace(",", ".");
    }

    /**
        * This method is used to get the EUR currency data.
        * @Scheduled(cron = "0 0 13-15 * * *") - this method is called every day from 13:00 to 15:00
     */
    @Scheduled(cron = "0 0 13-15 * * *")
    public String getEUR() {
        return (SortCurrencyData(getCurrencyData(getURLFromDate(new Date())), "EUR").split("\\|")[4].replace(",", "."));
    }

    /**
        * This method is used to get the GBP currency data.
        * @Scheduled(cron = "0 0 13-15 * * *") - this method is called every day from 13:00 to 15:00
     */
    @Scheduled(cron = "0 0 13-15 * * *")
    public String getGBP() {
        return (SortCurrencyData(getCurrencyData(getURLFromDate(new Date())), "GBP").split("\\|")[4].replace(",", "."));
    }


    /**
        * This method is used to check if the currency data is actual.
        * @return true if the currency data is actual, false if the currency data is not actual
        * TODO
     */
    public boolean isDataActual() {
        return new Calendar().isWeekend();

    }

    /**
        * This method is used to get the exchange rate between two currencies.
        * @param from - currency we want to exchange
        * @param to - currency we want to get
        * @return exchange rate between two currencies
     */
    public double getExchangeRate(String from, String to){
        if (from.equals("CZK") && to.equals("USD")) {
            return 1 / Double.parseDouble(getUSD());
        } else if (from.equals("USD") && to.equals("CZK")) {
            return Double.parseDouble(getUSD());
        } else if (from.equals("CZK") && to.equals("EUR")) {
            return 1 / Double.parseDouble(getEUR());
        } else if (from.equals("EUR") && to.equals("CZK")) {
            return Double.parseDouble(getEUR());
        } else if (from.equals("USD") && to.equals("EUR")) {
            return Double.parseDouble(getUSD()) / Double.parseDouble(getEUR());
        } else if (from.equals("EUR") && to.equals("USD")) {
            return Double.parseDouble(getEUR()) / Double.parseDouble(getUSD());
        }
        return 0;
    }

}
