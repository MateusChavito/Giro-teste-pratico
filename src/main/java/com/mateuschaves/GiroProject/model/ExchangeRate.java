package com.mateuschaves.GiroProject.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private BigDecimal dailyVariation;
    private BigDecimal dailyRate;

    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    @JsonIgnoreProperties({"name", "type"})
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

    public BigDecimal getDailyVariation() {
        return dailyVariation;
    }

    public void setDailyVariation(BigDecimal dailyVariation) {
        this.dailyVariation = dailyVariation;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public ExchangeRate(Currency currency, BigDecimal dailyRate, BigDecimal dailyVariation, Date date) {
        this.currency = currency;
        this.dailyRate = dailyRate;
        this.dailyVariation = dailyVariation;
        this.date = date;
    }
}
