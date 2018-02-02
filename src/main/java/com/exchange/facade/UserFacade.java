package com.exchange.facade;

import com.exchange.domain.Cantor;
import com.exchange.domain.User;
import com.exchange.domain.currency.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Lenovo on 02.02.2018.
 */
@Component
public class UserFacade {

    @Autowired
    private Cantor cantor;

    public void createWallet(User user, Currency currency, int quantity){
    }

}
