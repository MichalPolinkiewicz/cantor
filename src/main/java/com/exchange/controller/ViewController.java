package com.exchange.controller;

import com.exchange.domain.dto.CurrencyDto;
import com.exchange.facade.CantorFacade;
import com.exchange.mapper.CurrencyMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private CantorFacade cantorFacade;
    @Autowired
    private CurrencyMapper currencyMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String getWelcome(){
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String getLogin(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logged")
    public String getLogged(Map <String, Object> model){
        List<CurrencyDto> currencyDtos = currencyMapper.mapToCurrencyDtoList(cantorFacade.getCantor());
        model.put("currencies", currencyDtos);
        return "logged";
    }
}
