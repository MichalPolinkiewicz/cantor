package com.exchange.controller;

import com.exchange.domain.Transaction;
import com.exchange.domain.dto.CurrencyDto;
import com.exchange.domain.dto.UserDto;
import com.exchange.domain.user.User;
import com.exchange.facade.UserFacade;
import com.exchange.mapper.CurrencyMapper;
import com.exchange.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;


/**
 * Created by Lenovo on 01.02.2018.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;
    @Autowired
    private CurrencyMapper currencyMapper;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.POST, value = "/add", consumes = {APPLICATION_FORM_URLENCODED_VALUE})
    public void addUser(@ModelAttribute @Valid User user) throws Exception{
        userFacade.addUser(user);
    }

//    @RequestMapping(method = RequestMethod.PATCH, value = "/init", params = {"userId", "currencyId", "value"})
//    public void initWallet(@RequestParam("userId") Long userId, @RequestParam("currencyId") Long currencyId,
//                           @RequestParam("value") double value) throws Exception{
//        userFacade.initWallet(userId, currencyId, value);
//    }

    @RequestMapping(method = RequestMethod.PUT, value = "/edit")
    public User editUser(@RequestBody User user) throws Exception{
        return userFacade.editUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buy", params = {"userId", "currencyId", "quantity"})
    public void buy(@RequestParam("userId") Long userId, @RequestParam("currencyId") Long currencyId,
                    @RequestParam("quantity") double quantity) throws Exception{
        userFacade.buy(userId, currencyId, quantity);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sell", params = {"userId", "currencyId", "quantity"})
    public void sell(@RequestParam("userId") Long userId, @RequestParam("currencyId") Long currencyId,
                     @RequestParam("quantity") double quantity) throws Exception{
        userFacade.sell(userId,currencyId,quantity);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/wallet")
    public List<CurrencyDto> getWallet (@PathVariable("id") Long userId) throws Exception{
        return currencyMapper.mapToCurrencyDtoList(userFacade.getUserById(userId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public UserDto getUser(@PathVariable("id") Long id) throws Exception{
        return userMapper.mapToUserDto(userFacade.getUserById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/saldo")
    public double getSaldo(@PathVariable("id") Long id) throws Exception{
        return userMapper.mapToUserDto(userFacade.getUserById(id)).getSaldo();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/transactions")
    public List<Transaction> getTransactions(@PathVariable("id") Long id) throws Exception{
        return userFacade.getUserById(id).getTransactions();
    }

}
