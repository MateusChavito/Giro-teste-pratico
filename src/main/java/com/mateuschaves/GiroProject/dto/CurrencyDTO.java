package com.mateuschaves.GiroProject.dto;

import com.mateuschaves.GiroProject.model.Currency;

public class CurrencyDTO {

    private Long id;

    public CurrencyDTO() {}

    public CurrencyDTO(Currency currency) {
        if (currency != null) {
            this.id = currency.getId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
