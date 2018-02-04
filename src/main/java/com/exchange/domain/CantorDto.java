package com.exchange.domain;

import java.util.Map;

/**
 * Created by Lenovo on 03.02.2018.
 */
public class CantorDto {

    private Long id;
    private String dateOfActualization;
    private Map<Currency, Double> portfolio;

    public CantorDto() {
    }

    public CantorDto(Long id, String dateOfActualization, Map<Currency, Double> portfolio) {
        this.id = id;
        this.dateOfActualization = dateOfActualization;
        this.portfolio = portfolio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateOfActualization() {
        return dateOfActualization;
    }

    public void setDateOfActualization(String dateOfActualization) {
        this.dateOfActualization = dateOfActualization;
    }

    public Map<Currency, Double> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Map<Currency, Double> portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Cantor{" +
                "id=" + id +
                ", dateOfActualization='" + dateOfActualization + '\'' +
                ", portfolio=" + portfolio +
                '}';
    }
}
