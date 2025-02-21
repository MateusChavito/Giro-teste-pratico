package com.mateuschaves.GiroProject.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private float dailyVariation;
    private float dailyRate;

    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    public ExchangeRate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getDailyVariation() {
        return dailyVariation;
    }

    public void setDailyVariation(float dailyVariation) {
        this.dailyVariation = dailyVariation;
    }

    public float getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(float dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public ExchangeRate(Currency currency, float dailyRate, float dailyVariation, Date date) {
        this.currency = currency;
        this.dailyRate = dailyRate;
        this.dailyVariation = dailyVariation;
        this.date = date;
    }
}
