package com.example.currencyconverterapp.model;

import java.util.Map;

public class ExchangeRateApiResponse {

    private Map<String, Double> rates;

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
