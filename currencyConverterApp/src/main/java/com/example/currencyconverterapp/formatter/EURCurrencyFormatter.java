package com.example.currencyconverterapp.formatter;

public class EURCurrencyFormatter implements CurrencyFormatter {
    @Override
    public String format(double amount) {
        return String.format("%.2f", amount);
    }
}
