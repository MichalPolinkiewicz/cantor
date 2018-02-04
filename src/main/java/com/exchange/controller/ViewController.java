package com.exchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Lenovo on 03.02.2018.
 */
@RequestMapping("/v1/exchange")
@Controller
public class ViewController {

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String getWelcome(){
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String getCreate(){
        return "create";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logged")
    public String forLogged(){
        return "forLogged";
    }
}
