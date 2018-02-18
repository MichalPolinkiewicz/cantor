package com.exchange.controller;

import com.exchange.domain.Transaction;
import com.exchange.domain.dto.CurrencyDto;
import com.exchange.domain.user.User;
import com.exchange.exception.NotAveliableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 07.02.2018.
 */
@Controller
@RequestMapping("/")
public class ViewController {

    @Autowired
    private CantorController cantorController;
    @Autowired
    private UserController userController;

    public User getUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loginPage")
    public String getLogin(){
        return "loginPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String getLogged(Map <String, Object> model) throws Exception{
        List<CurrencyDto> currencyDtos = cantorController.getActualCantorCurrencies();
        User user;
        try {
            user = getUser();
        } catch (Exception e){
            return "accessError";
        }

        List<CurrencyDto> userCurrencies = userController.getWallet(user.getId());
        List <Transaction> transactions = userController.getTransactions(user.getId());
        double saldo = userController.getSaldo(user.getId());

        model.put("date", cantorController.getActualizationData());
        model.put("currencies", currencyDtos);
        model.put("userWallet", userCurrencies);
        model.put("userId", user.getId());
        model.put ("saldo", saldo);
        model.put("userName", user.getName() + " " + user.getSurname());


        return "main";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accountForm")
    public String getCreateAccount(){
        return "accountForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String addUser(@ModelAttribute @Valid User user) throws Exception{
            try {
                userController.addUser(user);
                return "registrationSuccess";
            } catch (Exception e){
                return "error";
            }
        }

    @RequestMapping(method = RequestMethod.GET, value = "/loginError")
    public String getLoginError(){
        return "loginError";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buy")
    public String buy(Long userId, Long currencyId, double quantity) throws Exception{
        try {
            userController.buy(userId, currencyId, quantity);
            return "transactionSuccess";
        } catch (NotAveliableException e){
            return "transactionFail";
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/sell")
    public String sell(Long userId, Long currencyId, double quantity) throws Exception{
        try {
            userController.sell(userId, currencyId, quantity);
            return "transactionSuccess";
        } catch (NotAveliableException e){
            return "transactionFail";
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/transactions")
    public String getTransactions(Map <String, Object> model){
        User user;
        try {
            user = getUser();
            List<Transaction> transactions = userController.getTransactions(user.getId());
            model.put("transactions", transactions);
            return "transactions";
        } catch (Exception e){
            return "accessError";
        }
    }
}
