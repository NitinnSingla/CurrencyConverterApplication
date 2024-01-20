package com.example.currencyconverterapp.controller;

import com.example.currencyconverterapp.service.CurrencyConverterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConverterController {

    private final CurrencyConverterService currencyConverterService;

    public CurrencyConverterController(CurrencyConverterService currencyConverterService) {
        this.currencyConverterService = currencyConverterService;
    }

    // server port is 8070
    // run this http://localhost:8070/index.html

    @GetMapping("/currency/convert")
    public ResponseEntity<String> convertCurrency(
            @RequestParam String sourceCurrency,
            @RequestParam String targetCurrency,
            @RequestParam double sourceAmount) {
        String convertedAmount = currencyConverterService.convertCurrency(sourceCurrency,targetCurrency,sourceAmount);
        return ResponseEntity.ok(convertedAmount);
    }
}
