package com.mateuschaves.GiroProject.controller;


import com.mateuschaves.GiroProject.model.InvestmentHistory;
import com.mateuschaves.GiroProject.repository.InvestmentHistoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/investments")
public class InvestmentHistoryController {

    private final InvestmentHistoryRepository investmentHistoryRepository;

    public InvestmentHistoryController(InvestmentHistoryRepository investmentHistoryRepository) {
        this.investmentHistoryRepository = investmentHistoryRepository;
    }

    @GetMapping
    public List<InvestmentHistory> getAllInvestmentHistories(){
        return investmentHistoryRepository.findAll();

    }

    @PostMapping
    public ResponseEntity<InvestmentHistory> createInvestmentHistory(@RequestBody InvestmentHistory investmentHistory){
        InvestmentHistory savedInvestmentHistory = investmentHistoryRepository.save(investmentHistory);
        return new ResponseEntity<>(savedInvestmentHistory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<InvestmentHistory>updateInvestmentHistory(@PathVariable Long id, @RequestBody InvestmentHistory investmentDetails){
        Optional<InvestmentHistory> investmentHistoryOptional = investmentHistoryRepository.findById(id);
        if(investmentHistoryOptional.isPresent()){
            InvestmentHistory investmentHistory = investmentHistoryOptional.get();
            investmentHistory.setInitialAmount(investmentDetails.getInitialAmount());
            investmentHistory.setInterestRate(investmentDetails.getInterestRate());
            investmentHistory.setFinalAmount(investmentDetails.getFinalAmount());
            investmentHistory.setCurrency(investmentDetails.getCurrency());
            investmentHistory.setInvestor(investmentDetails.getInvestor());

            return new ResponseEntity<>(investmentHistory, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InvestmentHistory> deleteInvestmentHistory(@PathVariable Long id){
        if(investmentHistoryRepository.existsById(id)){
            investmentHistoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
