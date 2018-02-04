package com.exchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lenovo on 03.02.2018.
 */
@RequestMapping("/v1/exchange")
@Controller
public class ViewController {

    @RequestMapping(value = "/")
    public String getWelcome(){
        return "welcome";
    }

    @RequestMapping(value = "/create")
    public String getCreate(){
        return "create";
    }

    @RequestMapping(value = "/logged")
    public String forLogged(){
        return "forLogged";
    }
}
