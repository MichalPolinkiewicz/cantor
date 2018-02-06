package com.exchange.domain.dto;

/**
 * Created by Lenovo on 06.02.2018.
 */
public class CurrencyDto {

    private Long id;
    private String name;
    private String code;
    private int unit;
    private double purchasePrice;
    private double sellPrice;
    private double averagePrice;
    private double amount;


    public CurrencyDto(Long id, String name, String code, int unit, double purchasePrice, double sellPrice, double averagePrice, double amount) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.unit = unit;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
        this.averagePrice = averagePrice;
        this.amount = amount;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
