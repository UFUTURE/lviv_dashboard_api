package com.yuchiapi.yuchiapi.service.impl;

import java.io.IOException;
import java.net.URL;
import com.yuchiapi.yuchiapi.db.InMemoryDB;
import com.yuchiapi.yuchiapi.service.CurrencyService;
import com.yuchiapi.yuchiapi.util.DataCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private static final String currencyApi = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
    private static final String cryptoCurrencyApi = "https://rest.coinapi.io/v1/assets?apikey="
            + "FE944BC0-29C9-46C3-B054-F7237F65018C&filter_asset_id=BTC;ETC;XRP;BNB";
    @Autowired
    private DataCollector dataCollector;

    @Override
    public String getCurrency() {
        return InMemoryDB.currency;
    }

    @Override
    public void collectCurrencyAndSaveToDB() throws IOException {
        InMemoryDB.currency = dataCollector.createReport(new URL(currencyApi));
    }

    @Override
    public String getCryptoCurrency() {
        return InMemoryDB.cryptoCurrency;
    }

    @Override
    public void collectCryptoCurrencyAndSaveToDB() throws IOException {
        InMemoryDB.cryptoCurrency = dataCollector.createReport(new URL(cryptoCurrencyApi));
    }

    @Override
    public String getPrevCurrency() {
        return InMemoryDB.prev_currency;
    }

    @Override
    public String getPrevCryptoCurrency() {
        return InMemoryDB.prev_cryptoCurrency;
    }
}
