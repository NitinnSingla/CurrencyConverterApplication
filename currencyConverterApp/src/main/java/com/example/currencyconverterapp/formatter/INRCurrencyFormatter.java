package com.example.currencyconverterapp.formatter;

public class INRCurrencyFormatter implements CurrencyFormatter {
    @Override
    public String format(double amount) {
        return String.format("%.2f", amount);
    }
}
