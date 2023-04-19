package com.yuchiapi.yuchiapi.service;

import java.io.IOException;

public interface CurrencyService {
    String getCurrency();
    String getCryptoCurrency();
    String getPrevCurrency();
    String getPrevCryptoCurrency();

    void collectCurrencyAndSaveToDB() throws IOException;
    void collectCryptoCurrencyAndSaveToDB() throws IOException;
}
