package com.example.currencyconverterapp.factory;

import com.example.currencyconverterapp.formatter.*;

public class CurrencyFormatterFactory {
    public static CurrencyFormatter getCurrencyFormatter(String currencyCode){
        switch (currencyCode) {
            case "INR":
                return new INRCurrencyFormatter();
            case "USD":
                return new USDCurrencyFormatter();
            case "EUR":
                return new EURCurrencyFormatter();
            case "JPY":
                return new JPYCurrencyFormatter();
            default:
                return new DefaultCurrencyFormatter();
        }
    }
}
