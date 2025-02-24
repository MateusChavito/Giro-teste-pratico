package com.mateuschaves.GiroProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mateuschaves.GiroProject.model.ExchangeRate;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

public class ExchangeRateDTO {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private BigDecimal dailyVariation;
    private BigDecimal dailyRate;
    private CurrencyDTO currency;

    public ExchangeRateDTO(ExchangeRate exchangeRate) {
        this.id = exchangeRate.getId();  // Captura o ID corretamente
        this.date = exchangeRate.getDate();
        this.dailyVariation = exchangeRate.getDailyVariation();
        this.dailyRate = exchangeRate.getDailyRate();
        this.currency = new CurrencyDTO(exchangeRate.getCurrency());
    }
    public Long getId() {  // Adicionando o getter do ID
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

    public CurrencyDTO getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyDTO currency) {
        this.currency = currency;
    }
}
