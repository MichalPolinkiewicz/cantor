package com.exchange.controller;

import com.exchange.domain.dto.CurrencyDto;
import com.exchange.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 07.02.2018.
 */
@Controller
@RequestMapping("/v1/exchange")
public class ViewController {

    @Autowired
    private CantorController cantorController;
    @Autowired
    private UserController userController;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getLogin(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String getLogged(Map <String, Object> model) throws Exception{
        List<CurrencyDto> currencyDtos = cantorController.getActualCantorCurrencies();
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<CurrencyDto> userCurrencies = userController.getWallet(user.getId());

        model.put("date", cantorController.getActualizationData());
        model.put("currencies", currencyDtos);
        model.put("userWallet", userCurrencies);
        model.put ("saldo", userController.getSaldo(user.getId()));
        model.put("userName", user.getName() + " " + user.getSurname());

        return "exchange";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/createAccount")
    public String getCreateAccount(){
        return "createAccount";
    }
}
