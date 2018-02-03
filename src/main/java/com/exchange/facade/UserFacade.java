package com.exchange.facade;

import com.exchange.domain.Cantor;
import com.exchange.domain.Currency;
import com.exchange.domain.User;
import com.exchange.exception.NotAveliableException;
import com.exchange.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Lenovo on 02.02.2018.
 */
@Component
public class UserFacade {

    @Autowired
    private Cantor cantor;
    @Autowired
    private DbService dbService;

    public void addUser(User user){
        dbService.saveUser(user);
    }

    public void buy(Long userId, Long currencyId, Double quantity) throws Exception{
        User user = dbService.getUserById(userId).orElseThrow(NotAveliableException::new);
        Currency currency = dbService.getCurrencyById(currencyId).orElseThrow(NotAveliableException::new);

        int unit = currency.getUnit();
        boolean isMultiply = quantity % unit==0;
        double actualPrice = currency.getPurchasePrice() / unit;
        double priceForUser = quantity * actualPrice;

        double cantorQty = cantor.getPortfolio().get(currency);
        boolean aveliable = cantorQty > quantity;
        boolean enoughMoney = user.getSaldo() > priceForUser;

        if(isMultiply & aveliable & enoughMoney){
            double newValue = cantor.getPortfolio().get(currency) - quantity;
            cantor.getPortfolio().replace(currency, newValue);

            if(user.getWallet().containsKey(currency)){
                double oldValue = user.getWallet().get(currency);
                user.getWallet().replace(currency, oldValue + quantity);
                } else {
                    user.getWallet().put(currency, quantity);
                }

                user.setSaldo(user.getSaldo() - priceForUser);
            dbService.saveUser(user);
            dbService.saveCantor(cantor);
            } else {
            throw new NotAveliableException();
        }
    }


    public void sell(Long userId, Long currencyId, Double quantity) throws Exception{
        User user = dbService.getUserById(userId).orElseThrow(NotAveliableException::new);
        Currency currency = dbService.getCurrencyById(currencyId).orElseThrow(NotAveliableException::new);

        boolean hasEnough = user.getWallet().get(currency) >= quantity;
        int unit = currency.getUnit();
        boolean isMultiply = quantity % unit == 0;

        if (hasEnough & isMultiply){
            double oldValue = cantor.getPortfolio().get(currency);
            double price = quantity * currency.getSellPrice();
            cantor.getPortfolio().replace(currency, oldValue + quantity);
            user.setSaldo(user.getSaldo()+price);
        } else {
            throw new NotAveliableException();
        }
    }

    public Map<Currency, Double> getActualWallet(Long userId) throws Exception{
        User user = dbService.getUserById(userId).orElseThrow(NotAveliableException::new);
        return user.getWallet();
    }

    public double getSaldo(Long userId)throws Exception{
        User user = dbService.getUserById(userId).orElseThrow(NotAveliableException::new);
        return user.getSaldo();
    }


}
