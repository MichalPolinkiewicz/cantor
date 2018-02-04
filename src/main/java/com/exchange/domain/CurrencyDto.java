package com.exchange.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 03.02.2018.
 */
public class CurrencyDto {

    private Long id;
    private String name;
    private String code;
    private int unit;
    private double purchasePrice;
    private double sellPrice;
    private double averagePrice;
    private List<Double> averagePrices = new ArrayList<>();

    public CurrencyDto() {
    }

    public CurrencyDto(Long id, String name, String code, int unit, double purchasePrice, double sellPrice, double averagePrice, List<Double> averagePrices) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.unit = unit;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
        this.averagePrice = averagePrice;
        this.averagePrices = averagePrices;
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

    public List<Double> getAveragePrices() {
        return averagePrices;
    }

    public void setAveragePrices(List<Double> averagePrices) {
        this.averagePrices = averagePrices;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", unit=" + unit +
                ", purchasePrice=" + purchasePrice +
                ", sellPrice=" + sellPrice +
                ", averagePrice=" + averagePrice +
                ", averagePrices=" + averagePrices +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;

        Currency currency = (Currency) o;

        return getCode() != null ? getCode().equals(currency.getCode()) : currency.getCode() == null;
    }

    @Override
    public int hashCode() {
        return getCode() != null ? getCode().hashCode() : 0;
    }
}
