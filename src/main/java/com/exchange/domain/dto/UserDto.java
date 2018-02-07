package com.exchange.domain.dto;

/**
 * Created by Lenovo on 07.02.2018.
 */
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String login;
    private double saldo;

    public UserDto() {
    }

    public UserDto(Long id, String name, String surname, String login, double saldo) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.saldo = saldo;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
