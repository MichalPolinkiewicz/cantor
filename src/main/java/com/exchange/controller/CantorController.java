package com.exchange.controller;

import com.exchange.client.ResponseObject;
import com.exchange.domain.Cantor;
import com.exchange.facade.CantorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lenovo on 01.02.2018.
 */
@RestController
@RequestMapping("/v1/cantor/")
public class CantorController {

   @Autowired
   private CantorFacade cantorFacade;

    @RequestMapping(method = RequestMethod.PATCH, value = "transaction", params = {"uderId", "currencyId"})
    public void doTransaction(@RequestParam("userId") Long userId, @RequestParam("currencyId") Long crId){}

    @RequestMapping(method = RequestMethod.GET, value = "test")
    public ResponseObject testItem(){
        return cantorFacade.getDataFromServer();
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "open")
    public void openCantor(){
        cantorFacade.openCantor();
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "init")
    public void initDatas(){
        cantorFacade.act();
    }

    @RequestMapping(method = RequestMethod.GET, value = "cantor")
    public Cantor getCantor(){
        return cantorFacade.getCantor();
    }


}
