package com.exchange.domain.user;

import com.exchange.domain.Currency;
import com.exchange.domain.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Lenovo on 01.02.2018.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private double saldo;
    @JsonIgnore
    @ElementCollection
    @CollectionTable(name = "userQuantitys", joinColumns = {@JoinColumn(name = "user_Id")})
    @MapKeyJoinColumn(name = "currency_Id")
    @Column(name = "quantity")
    private Map<Currency, Double> wallet;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "usersAndRoles",
            joinColumns = {@JoinColumn(name = "user_Id")},
            inverseJoinColumns = {@JoinColumn(name = "role_Id")})
    private Set<UserRole> roles;
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    public User() {
    }

    public User(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.saldo = user.getSaldo();
        this.wallet = user.getWallet();
        this.roles = user.getRoles();
        this.transactions = user.getTransactions();
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
