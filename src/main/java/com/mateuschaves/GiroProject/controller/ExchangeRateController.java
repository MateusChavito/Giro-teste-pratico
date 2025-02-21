package com.mateuschaves.GiroProject.controller;

import com.mateuschaves.GiroProject.model.ExchangeRate;
import com.mateuschaves.GiroProject.repository.ExchangeRateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Repository
@RequestMapping("/exchange-rates")
public class ExchangeRateController {

    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeRateController(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @GetMapping
    public List<ExchangeRate> getAllExchangeRates() {
        return exchangeRateRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<ExchangeRate> createExchangeRate(@RequestBody ExchangeRate exchangeRate) {
        ExchangeRate savedExchangeRate = exchangeRateRepository.save(exchangeRate);
        return new ResponseEntity<>(savedExchangeRate, HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<ExchangeRate> updateExchangeRate(@PathVariable Long id, ExchangeRate exchangeRateDetails) {
        Optional<ExchangeRate> exchangeRateOptional = exchangeRateRepository.findById(id);
        if (exchangeRateOptional.isPresent()) {
            ExchangeRate exchangeRate = exchangeRateOptional.get();
            exchangeRate.setDailyRate(exchangeRateDetails.getDailyRate());
            exchangeRate.setDailyVariation(exchangeRateDetails.getDailyVariation());
            exchangeRate.setCurrency(exchangeRateDetails.getCurrency());
            exchangeRateRepository.save(exchangeRate);
            return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping
    private ResponseEntity<Void> deleteExchangeRate(@PathVariable Long id){
        if(exchangeRateRepository.existsById(id)){
            exchangeRateRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




















}
