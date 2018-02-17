package com.exchange.controller;

import com.exchange.domain.dto.CurrencyDto;
import com.exchange.domain.user.User;
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
@RequestMapping("/exchange")
public class ViewController {

    @Autowired
    private CantorController cantorController;
    @Autowired
    private UserController userController;

    @RequestMapping(method = RequestMethod.GET, value = "/loginPage")
    public String getLogin(){
        return "loginPage";
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
                return "registrationSucess";
            } catch (Exception e){
                return "error";
            }
        }

    @RequestMapping(method = RequestMethod.GET, value = "/loginError")
    public String getLoginError(){
        return "loginError";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/1")
    public String get1 (){
        return "1";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/2")
    public String get2 (){

        return "1";
    }

}
