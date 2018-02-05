package com.exchange.domain;

import com.exchange.domain.user.User;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Lenovo on 04.02.2018.
 */
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_Id")
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Currency currency;
    private Date date;
    private String type;
    private double quantity;
    private double value;
    private double unitPrice;

    public Transaction() {
    }

    public Transaction(User user, Currency currency, Date date, String type, double quantity, double value, double unitPrice) {
        this.user = user;
        this.currency = currency;
        this.date = date;
        this.type = type;
        this.quantity = quantity;
        this.value = value;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
