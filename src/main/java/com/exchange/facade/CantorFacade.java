package com.exchange.facade;

import com.exchange.client.CurrencyClient;
import com.exchange.client.Item;
import com.exchange.domain.Cantor;
import com.exchange.domain.Currency;
import com.exchange.service.DbService;
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
    private CurrencyClient currencyClient;
    @Autowired
    private Cantor cantor;
    @Autowired
    private DbService dbService;

    public void openCantor(){
        List<Item> items = currencyClient.getDataFromServer().getItems();
        Map<Currency, Double> portfolio = new HashMap<>();

        for(Item item : items){
            Currency currency = new Currency();
            currency.setCode(item.getCode());
            portfolio.put(currency, 5000.0);
            dbService.saveCurrency(currency);
        }

        cantor.setPortfolio(portfolio);
        dbService.saveCantor(cantor);
    }

    public void actualizeCantor (){
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
                        dbService.saveCurrency(currency);
                    }
                }
            }
            dbService.saveCantor(cantor);
    }}

    public String getActualizationTime(){
        return cantor.getDateOfActualization();
    }

    public Cantor getCantor(){
        return cantor;
    }

}
