package com.mateuschaves.GiroProject.service;

import com.mateuschaves.GiroProject.model.ExchangeRate;
import com.mateuschaves.GiroProject.repository.ExchangeRateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExchangeRateService {

    private ExchangeRateRepository exchangeRateRepository;

    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository){
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public List<ExchangeRate>getALlExchangeRates(){
        return exchangeRateRepository.findAll();
    }

    public ExchangeRate getExchangeRateByID(Long id){
        return exchangeRateRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Taxa de câmbio não foi encontrada."));
    }

    public ExchangeRate createExchangeRate(ExchangeRate exchangeRate){
        return exchangeRateRepository.save(exchangeRate);
    }

    public ExchangeRate updateExchangeRate(Long id, ExchangeRate exchangeRateDetails){
        ExchangeRate exchangeRate = getExchangeRateByID(id);
        exchangeRate.setDate(exchangeRateDetails.getDate());
        exchangeRate.setDailyRate(exchangeRateDetails.getDailyRate());
        exchangeRate.setDailyVariation(exchangeRateDetails.getDailyVariation());
        exchangeRate.setCurrency(exchangeRateDetails.getCurrency());
        return exchangeRateRepository.save(exchangeRate);
    }

    public void deletarExnchegeRate(Long id){
        ExchangeRate exchangeRate = getExchangeRateByID(id);
        exchangeRateRepository.delete(exchangeRate);
    }


}
