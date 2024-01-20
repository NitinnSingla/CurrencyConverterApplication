package com.example.currencyconverterapp.formatter;

public class JPYCurrencyFormatter implements CurrencyFormatter {
    @Override
    public String format(double amount) {
        return String.format("%.0f", amount);
    }
}
