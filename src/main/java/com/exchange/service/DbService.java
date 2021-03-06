package com.exchange.service;

import com.exchange.domain.Cantor;
import com.exchange.domain.Currency;
import com.exchange.domain.Transaction;
import com.exchange.domain.user.User;
import com.exchange.domain.user.UserRole;
import com.exchange.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    @Autowired
    private UserRoleRepository userRoleRepository;

    //Currency

    public Currency saveCurrency(Currency currency){
        return currencyRepository.save(currency);
    }

    public Optional<Currency> getCurrencyById(Long id){
        return currencyRepository.findCurrencyById(id);
    }

    //Cantor
    public Cantor saveCantor(Cantor cantor){
        return cantorRepository.save(cantor);
    }

    public List<Cantor> getCantors(){
        return cantorRepository.findAll();
    }

    public Cantor getFirst(){
        return cantorRepository.getFirstByIdIsNotNull();
    }

    //User
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
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

    public Optional<User> findUserByLogin(String login){
        return userRepository.findUserByLogin(login);
    }

    //UserRole
    public UserRole saveUserRole(UserRole userRole){
        return userRoleRepository.save(userRole);
    }
    //Transaction
    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
