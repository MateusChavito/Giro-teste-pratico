package com.mateuschaves.GiroProject.controller;

import com.mateuschaves.GiroProject.model.Currency;
import com.mateuschaves.GiroProject.repository.CurrencyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyRepository currencyRepository;

    public CurrencyController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @GetMapping
    public List<Currency>getAllCurrencies(){
        return currencyRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Currency> createCurrency(@RequestBody Currency currency) {
        Currency savedCurrency = currencyRepository.save(currency);
        return new ResponseEntity<>(savedCurrency, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Currency> updateCurrency(@PathVariable Long id, @RequestBody Currency currencyDetails){
        Optional<Currency> currencyOptional = currencyRepository.findById(id);
        if(currencyOptional.isPresent()){
            Currency currency = currencyOptional.get();
            currency.setName(currencyDetails.getName());
            currency.setType(currencyDetails.getType());
            currencyRepository.save(currency);
            return new ResponseEntity<>(currency, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<Currency> deleteCurrency(@PathVariable Long id){
        if(currencyRepository.existsById(id)){
            currencyRepository.existsById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
