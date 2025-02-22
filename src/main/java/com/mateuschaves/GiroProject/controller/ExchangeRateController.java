package com.mateuschaves.GiroProject.controller;

import com.mateuschaves.GiroProject.model.ExchangeRate;
import com.mateuschaves.GiroProject.repository.ExchangeRateRepository;
import com.mateuschaves.GiroProject.service.ExchangeRateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Repository
@RequestMapping("/api/exchange-rates")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService){
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping
    public ResponseEntity<List<ExchangeRate>>getAllExchangeRates(){
        List<ExchangeRate> exchangeRates = exchangeRateService.getALlExchangeRates();
        return new ResponseEntity<>(exchangeRates, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExchangeRate> exchangeRateById(@PathVariable Long id){
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRateByID(id);
        return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ExchangeRate> createExchangeRate(@RequestBody ExchangeRate exchangeRate) {
        ExchangeRate CreatedExchangeRate = exchangeRateService.createExchangeRate(exchangeRate);
        return new ResponseEntity<>(exchangeRate, HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<ExchangeRate> updateExchangeRate(@PathVariable Long id, @RequestBody ExchangeRate exchangeRateDetails){
        ExchangeRate updatedExchangeRate = exchangeRateService.updateExchangeRate(id, exchangeRateDetails);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    private ResponseEntity<Void> deleteExchangeRate(@PathVariable Long id) {
        exchangeRateService.deletarExnchegeRate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }













}
