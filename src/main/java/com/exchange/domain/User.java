package com.exchange.domain;

import com.exchange.domain.currency.Currency;

import java.util.Map;

/**
 * Created by Lenovo on 01.02.2018.
 */
public class User {

    private Long id;
    private String name;
    private String surname;
    private String password;
    private double saldo;
    private Map<Currency, Double> wallet;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Map<Currency, Double> getWallet() {
        return wallet;
    }

    public void setWallet(Map<Currency, Double> wallet) {
        this.wallet = wallet;
    }
}
