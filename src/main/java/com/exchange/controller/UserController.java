package com.exchange.controller;

import com.exchange.domain.dto.CurrencyDto;
import com.exchange.domain.user.User;
import com.exchange.facade.UserFacade;
import com.exchange.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


/**
 * Created by Lenovo on 01.02.2018.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;
    @Autowired
    private Mapper mapper;

    @RequestMapping(method = RequestMethod.POST, value = "/add", consumes = APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody User user) throws Exception{
        userFacade.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/init", params = {"userId", "currencyId", "value"})
    public void initWallet(@RequestParam("userId") Long userId, @RequestParam("currencyId") Long currencyId,
                           @RequestParam("value") double value) throws Exception{
        userFacade.initWallet(userId, currencyId, value);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/edit")
    public User editUser(@RequestBody User user) throws Exception{
        return userFacade.editUser(user);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/buy", params = {"userId", "currencyId", "quantity"})
    public void buy(@RequestParam("userId") Long userId, @RequestParam("currencyId") Long currencyId,
                    @RequestParam("quantity") double quantity) throws Exception{
        userFacade.buy(userId, currencyId, quantity);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/sell", params = {"userId", "currencyId", "quantity"})
    public void sell(@RequestParam("userId") Long userId, @RequestParam("currencyId") Long currencyId,
                     @RequestParam("quantity") double quantity) throws Exception{
        userFacade.sell(userId,currencyId,quantity);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/wallet")
    public List<CurrencyDto> getWallet (@PathVariable("id") Long userId) throws Exception{
        return mapper.mapToCurrencyDtoList(userFacade.getUserById(userId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getUsers(){
        return userFacade.getUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public User getUser(@PathVariable("id") Long id) throws Exception{
        return userFacade.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/saldo")
    public double getSaldo(@PathVariable("id") Long id) throws Exception{
        return userFacade.getSaldo(id);
    }

}
