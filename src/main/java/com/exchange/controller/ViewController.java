package com.exchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Lenovo on 07.02.2018.
 */
@Controller
@RequestMapping("/v1/exchange")
public class ViewController {

    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String getWelcome(){
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String getLogin(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logged")
    public String getLogged(){
        return "logged";
    }
}
