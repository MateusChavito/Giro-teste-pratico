package com.mateuschaves.GiroProject.controller;

import com.mateuschaves.GiroProject.model.Currency;
import com.mateuschaves.GiroProject.repository.CurrencyRepository;
import com.mateuschaves.GiroProject.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }

    @GetMapping
    public ResponseEntity<List<Currency>> getAllCurrencies() {
        List<Currency> currencies = currencyService.getAllCurrencies();
        return new ResponseEntity<>(currencies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Currency> getCurrencyById(@PathVariable Long id){
        Currency currency = currencyService.getCurrencyById(id);
        return  new ResponseEntity<>(currency, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Currency> createCurrency(@RequestBody Currency currency) {
        Currency savedCurrency = currencyService.createCurrency(currency);
        return new ResponseEntity<>(savedCurrency, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Currency> updateCurrency(@PathVariable Long id, @RequestBody Currency currencyDetails) {
        Currency updatedCurrency = currencyService.updateCurrency(id, currencyDetails);
        return  new ResponseEntity<>(updatedCurrency, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Currency> deleteCurrency(@PathVariable Long id) {
        currencyService.deleteCurrency(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
