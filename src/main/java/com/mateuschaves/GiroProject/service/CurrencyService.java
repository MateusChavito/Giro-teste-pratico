package com.mateuschaves.GiroProject.service;

import com.mateuschaves.GiroProject.model.Currency;
import com.mateuschaves.GiroProject.repository.CurrencyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getAllCurrencies(){
        return currencyRepository.findAll();
    }

    public Currency createCurrency(Currency currency){
        return currencyRepository.save(currency);
    }

    public Currency getCurrencyById(Long id){
        return currencyRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Moeda não foi encontrada."));
    }

    public Currency updateCurrency(Long id, Currency currencyDetails){
        Currency currency = getCurrencyById(id);
        currency.setName(currencyDetails.getName());
        currency.setType(currencyDetails.getType());
        return currencyRepository.save(currency);
    }

    public void deleteCurrency(Long id){
        Currency currency = getCurrencyById(id);
        currencyRepository.delete(currency);
    }


}
