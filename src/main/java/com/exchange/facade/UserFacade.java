package com.exchange.facade;

import com.exchange.domain.Cantor;
import com.exchange.domain.Currency;
import com.exchange.domain.Transaction;
import com.exchange.domain.user.User;
import com.exchange.domain.user.UserRole;
import com.exchange.exception.NotAveliableException;
import com.exchange.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.*;

/**
 * Created by Lenovo on 02.02.2018.
 */
@Component
public class UserFacade {

    @Autowired
    private Cantor cantor;
    @Autowired
    private DbService dbService;


    public void addUser(User user) throws Exception{
        Optional<User> userSrn = dbService.findUserBySurname(user.getSurname());
        Optional<User> userNm = dbService.getUserByName(user.getName());
        if (userNm.isPresent() & userSrn.isPresent()){
            throw new NotAveliableException();
        }
        Set<UserRole> roleList = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRole("USER");
        roleList.add(userRole);
        user.setRoles(roleList);
        user.setSaldo(1500.0);
        dbService.saveUserRole(userRole);
        dbService.saveUser(user);

    }

    public void initWallet(Long userId, Long currencyId, double value) throws Exception{
        Currency currency = dbService.getCurrencyById(currencyId).orElseThrow(NotAveliableException::new);
        User user = dbService.getUserById(userId).orElseThrow(NotAveliableException::new);
        if (value > 1000) throw new NotAveliableException();
        if(user.getWallet().containsKey(currency)){
            user.getWallet().replace(currency, value);
        }
        user.getWallet().put(currency, value);
        dbService.saveUser(user);
    }

    public User editUser(User user) throws Exception{
        User user1 = dbService.getUserById(user.getId()).orElseThrow(NotAveliableException::new);
        return dbService.saveUser(user);
    }

    @Transactional
    public void buy(Long userId, Long currencyId, Double quantity) throws Exception{
        User user = dbService.getUserById(userId).orElseThrow(NotAveliableException::new);
        Currency currency = dbService.getCurrencyById(currencyId).orElseThrow(NotAveliableException::new);

        int unit = currency.getUnit();
        boolean isMultiply = quantity % unit==0;
        double actualPrice = currency.getSellPrice() / unit;
        double totalPrice = currency.getSellPrice() * quantity;
        double priceForUser = (quantity * actualPrice) * unit;

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
            Transaction transaction = new Transaction(user, currency,
                    Date.from(Instant.now()),"buy", quantity,totalPrice, currency.getSellPrice());
            dbService.saveUser(user);
            dbService.saveCantor(cantor);
            dbService.saveTransaction(transaction);

            } else {
            throw new NotAveliableException();
        }
    }


    @Transactional
    public void sell(Long userId, Long currencyId, Double quantity) throws Exception{
        User user = dbService.getUserById(userId).orElseThrow(NotAveliableException::new);
        Currency currency = dbService.getCurrencyById(currencyId).orElseThrow(NotAveliableException::new);

        boolean hasEnough = user.getWallet().get(currency) >= quantity;
        int unit = currency.getUnit();
        boolean isMultiply = quantity % unit == 0;

        if (hasEnough & isMultiply){
            double cantorOldValue = cantor.getPortfolio().get(currency);
            cantor.getPortfolio().replace(currency, cantorOldValue + quantity);
            double price = quantity * currency.getPurchasePrice();
            double userOldValue = user.getWallet().get(currency);
            user.getWallet().replace(currency, userOldValue-quantity);
            user.setSaldo(user.getSaldo()+price);
            Transaction transaction = new Transaction(user, currency, Date.from(Instant.now()),"sell", quantity,price, currency.getPurchasePrice());
            dbService.saveUser(user);
            dbService.saveCantor(cantor);
            dbService.saveTransaction(transaction);
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
