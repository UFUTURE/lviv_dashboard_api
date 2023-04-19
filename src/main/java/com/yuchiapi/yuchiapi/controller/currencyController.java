package com.yuchiapi.yuchiapi.controller;

import com.yuchiapi.yuchiapi.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
@RequestMapping("/currency")
public class currencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping()
    public String getCurrency() {
        return "{ \"current\":" + currencyService.getCurrency() + "," + "\"prev\":" + currencyService.getPrevCurrency() + "}";
    }
    @GetMapping("/prev")
    public String getPrevCurrency() {
        return currencyService.getPrevCurrency();
    }

    @GetMapping("/crypto/")
    public String getCrypto() {
        return "{ \"current\":" + currencyService.getCryptoCurrency() + "," + "\"prev\":" + currencyService.getPrevCryptoCurrency() + "}";
    }
    @GetMapping("/crypto/prev")
    public String getPrevCrypto() {
        return currencyService.getPrevCryptoCurrency();
    }
}
