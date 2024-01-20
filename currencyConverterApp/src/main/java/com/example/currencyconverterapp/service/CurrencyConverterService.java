package com.example.currencyconverterapp.service;

import com.example.currencyconverterapp.factory.CurrencyFormatterFactory;
import com.example.currencyconverterapp.formatter.CurrencyFormatter;
import com.example.currencyconverterapp.restClient.CurrencyConverterApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CurrencyConverterService {

    private final CurrencyConverterApiClient currencyConverterApiClient;

    @Autowired
    public CurrencyConverterService(
            CurrencyConverterApiClient currencyConverterApiClient) {
        this.currencyConverterApiClient = currencyConverterApiClient;
    }

    public String convertCurrency(String sourceCurrency, String targetCurrency, double amount) {
        Map<String, Double> exchangeRates = currencyConverterApiClient.getExchangeRates();
        if(!exchangeRates.containsKey(sourceCurrency) || !exchangeRates.containsKey(targetCurrency))
            throw new RuntimeException("Invalid Input");
        double sourceRate = exchangeRates.get(sourceCurrency);
        double targetRate = exchangeRates.get(targetCurrency);
        double convertedAmount = amount * (targetRate / sourceRate);
        CurrencyFormatter currencyFormatter = CurrencyFormatterFactory.getCurrencyFormatter(targetCurrency);
        return currencyFormatter.format(convertedAmount);
    }
}
