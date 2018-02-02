package com.exchange.facade;

import com.exchange.client.CurrencyClient;
import com.exchange.client.Item;
import com.exchange.client.ResponseObject;
import com.exchange.domain.Cantor;
import com.exchange.domain.currency.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 02.02.2018.
 */
@Component
public class CantorFacade {

    @Autowired
    CurrencyClient currencyClient;
    @Autowired
    private Cantor cantor;

    public void openCantor(){
        Currency czechKoruna = new CzechKoruna();
        czechKoruna.setCode("CZK");
        Currency euro = new Euro();
        euro.setCode("EUR");
        Currency poundSterling = new PoundSterling();
        poundSterling.setCode("GBP");
        Currency russianRuble = new RussianRuble();
        russianRuble.setCode("RUB");
        Currency swissFrank = new SwissFrank();
        swissFrank.setCode("CHF");
        Currency usDollar = new UsDollar();
        usDollar.setCode("USD");

        Map<Currency, Double> portfolio = new HashMap<>();
        portfolio.put(czechKoruna, 10000.00);
        portfolio.put(euro, 10000.00);
        portfolio.put(poundSterling, 10000.00);
        portfolio.put(russianRuble, 10000.00);
        portfolio.put(swissFrank, 10000.00);
        portfolio.put(usDollar, 10000.00);

        cantor.setPortfolio(portfolio);

    }

    public void act (){
        String data = currencyClient.getDataFromServer().getPublicationDate();

        if (!data.equals(cantor.getDateOfActualization())) {
            cantor.setDateOfActualization(data);

            List<Item> itemList = currencyClient.getDataFromServer().getItems();
            Map<Currency, Double> portfolio = cantor.getPortfolio();

            for (Map.Entry<Currency, Double> entry : portfolio.entrySet()) {
                Currency currency = entry.getKey();
                Item item;

                for (int n = 0; n < itemList.size(); n++) {
                    item = itemList.get(n);

                    if (currency.getCode().equals(item.getCode())) {
                        currency.setName(item.getName());
                        currency.setUnit(item.getUnit());
                        currency.setPurchasePrice(item.getPurchasePrice());
                        currency.setSellPrice(item.getSellPrice());
                        currency.setAveragePrice(item.getAveragePrice());
                        List<Double> prices = currency.getAveragePrices();
                        currency.setAveragePrices(prices);
                        prices.add(item.getAveragePrice());
                    }
                }
            }
    }}


//    public void actualizeCantor (){
//        String data = currencyClient.getDataFromServer().getPublicationDate();
//
//        if (!data.equals(cantor.getDateOfActualization())) {
//            cantor.setDateOfActualization(data);
//
//            List<Item> itemList = currencyClient.getDataFromServer().getItems();
//            List<Currency> currencyList = cantor.getPortfolio();
//
//            for (int i = 0; i < currencyList.size(); i++) {
//                Currency currency = currencyList.get(i);
//                Item item = new Item();
//
//                for (int n = 0; n < itemList.size(); n++) {
//                    item = itemList.get(n);
//
//                    if (currency.getCode().equals(item.getCode())) {
//                        currency.setName(item.getName());
//                        currency.setUnit(item.getUnit());
//                        currency.setPurchasePrice(item.getPurchasePrice());
//                        currency.setSellPrice(item.getSellPrice());
//                        currency.setAveragePrice(item.getAveragePrice());
//                        List<Double> prices = currency.getAveragePrices();
//                        currency.setAveragePrices(prices);
//                        prices.add(item.getAveragePrice());
//                    }
//                }
//            }
//        }
//    }

    public ResponseObject getDataFromServer(){
        return currencyClient.getDataFromServer();
    }

    public Cantor getCantor(){
        return cantor;
    }
}
