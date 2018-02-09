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
    private DbService dbService;

    public Cantor openCantor(){
        List<Item> items = currencyClient.getDataFromServer().getItems();
        Cantor cantor;
        if(dbService.getCantors().size()==0) {
            cantor = new Cantor();
            Map<Currency, Double> map = new HashMap<>();
            for (Item item : items) {
                Currency currency = new Currency();
                currency.setCode(item.getCode());
                dbService.saveCurrency(currency);
                map.put(currency, 5000.0);
                cantor.setPortfolio(map);
                dbService.saveCantor(cantor);
                actualizeCantor();
            }
        }
        cantor = dbService.getFirst();

        return cantor;
    }

    public void actualizeCantor (){
        Cantor cantor = openCantor();
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
        }
    }

    public String getActualizationTime(){
        return dbService.getFirst().getDateOfActualization();
    }

    public Cantor getCantor(){
        return dbService.getFirst();
    }
}
