package com.mateuschaves.GiroProject.controller;

import com.mateuschaves.GiroProject.model.ExchangeRate;
import com.mateuschaves.GiroProject.service.ExchangeRateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exchange-rates")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService){
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/recent")
    public ResponseEntity<List<ExchangeRate>> getRecentExchangeRates() {
        List<ExchangeRate> recentRates = exchangeRateService.getRecentExchangeRates();
        return ResponseEntity.ok(recentRates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExchangeRate> exchangeRateById(@PathVariable Long id){
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRateByID(id);
        return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExchangeRate> createExchangeRate(@RequestBody ExchangeRate exchangeRate) {
        ExchangeRate CreatedExchangeRate = exchangeRateService.createExchangeRate(exchangeRate);
        return new ResponseEntity<>(CreatedExchangeRate, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ExchangeRate> updateExchangeRate(@PathVariable Long id, @RequestBody ExchangeRate exchangeRateDetails){
        ExchangeRate updatedExchangeRate = exchangeRateService.updateExchangeRate(id, exchangeRateDetails);
        return new ResponseEntity<>(updatedExchangeRate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteExchangeRate(@PathVariable Long id) {
        exchangeRateService.deletarExnchegeRate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/old")
    public ResponseEntity<String> deleteOldExchangeRates() {
        exchangeRateService.deleteOldExchangeRates();
        return ResponseEntity.ok("As Taxas de câmbio mais antigas que 30 dias foram removidas.");
    }
}









