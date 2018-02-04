package com.exchange.service;

import com.exchange.domain.Cantor;
import com.exchange.domain.Transaction;
import com.exchange.domain.user.User;
import com.exchange.domain.Currency;
import com.exchange.repository.CantorRepository;
import com.exchange.repository.CurrencyRepository;
import com.exchange.repository.TransactionRepository;
import com.exchange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Lenovo on 03.02.2018.
 */
@Service
public class DbService {

    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private CantorRepository cantorRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public Currency saveCurrency(Currency currency){
        return currencyRepository.save(currency);
    }

    public Optional<Currency> getCurrencyById(Long id){
        return currencyRepository.findCurrencyById(id);
    }



    public Cantor saveCantor(Cantor cantor){
        return cantorRepository.save(cantor);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findUserById(id);
    }

    public Optional<User> getUserByName(String name){
        return userRepository.findUserByName(name);
    }

    public Optional<User> findUserBySurname(String surname){
        return userRepository.findUserBySurname(surname);
    }

    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
