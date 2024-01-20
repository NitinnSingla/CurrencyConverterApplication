package com.example.currencyconverterapp.restClient;

import com.example.currencyconverterapp.model.ExchangeRateApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class CurrencyConverterApiClient {

    private static final String API_ENDPOINT = "https://open.er-api.com/v6/latest/USD";
    private final RestTemplate restTemplate;

    public CurrencyConverterApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Double> getExchangeRates() {
        try {
            ExchangeRateApiResponse response = restTemplate.getForObject(API_ENDPOINT, ExchangeRateApiResponse.class);
            return response.getRates();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch exchange rates from the API.");
        }
    }
}
