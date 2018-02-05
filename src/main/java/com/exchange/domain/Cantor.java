package com.exchange.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Lenovo on 01.02.2018.
 */
@Entity
@Component
public class Cantor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cantor_Id")
    private Long id;
    private String dateOfActualization;
    @ElementCollection
    @CollectionTable(name = "cantorQuantitys", joinColumns = {@JoinColumn(name = "cantor_Id")})
    @MapKeyJoinColumn(name = "currency_Id")
    @Column(name = "quantityLeft")
    private Map<Currency, Double> portfolio;

    public Cantor() {
    }

    public Cantor(Long id,String dateOfActualization, Map<Currency, Double> portfolio) {
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
