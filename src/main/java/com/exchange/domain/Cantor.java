package com.exchange.domain;

import com.exchange.domain.currency.Currency;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Lenovo on 01.02.2018.
 */
@Component
public class Cantor {

    private String dateOfActualization;
    private Map<Currency, Double> portfolio;

    public Cantor() {
        this.dateOfActualization = dateOfActualization;
        this.portfolio = portfolio;
    }

    public Map<Currency, Double> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Map<Currency, Double> portfolio) {
        this.portfolio = portfolio;
    }

    public String getDateOfActualization() {
        return dateOfActualization;
    }

    public void setDateOfActualization(String dateOfActualization) {
        this.dateOfActualization = dateOfActualization;
    }

    @Override
    public String toString() {
        return "Cantor{" +
                "dateOfActualization='" + dateOfActualization + '\'' +
                ", portfolio=" + portfolio +
                '}';
    }
}
