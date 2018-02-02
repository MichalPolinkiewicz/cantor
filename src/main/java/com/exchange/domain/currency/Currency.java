package com.exchange.domain.currency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 01.02.2018.
 */
public class Currency {

    private String name;
    private String code;
    private int unit;
    private double purchasePrice;
    private double sellPrice;
    private double averagePrice;
    private List<Double> averagePrices = new ArrayList<>();

    public Currency() {
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

    public double calculateAvgPrice(){
        double sum = 0.0;
        for(int i = 1; i < averagePrices.size(); i++){
            sum = sum + averagePrices.get(i);
        } return sum/averagePrices.size();
    }

}
