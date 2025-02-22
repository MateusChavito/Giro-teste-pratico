package com.mateuschaves.GiroProject.controller;


import com.mateuschaves.GiroProject.model.InvestmentHistory;
import com.mateuschaves.GiroProject.repository.InvestmentHistoryRepository;
import com.mateuschaves.GiroProject.service.InvestmentHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investment-history")
public class InvestmentHistoryController {

    private final InvestmentHistoryService investmentHistoryService;

    public InvestmentHistoryController(InvestmentHistoryService investmentHistoryService) {
        this.investmentHistoryService = investmentHistoryService;
    }

    @PostMapping
    public ResponseEntity<InvestmentHistory> createInvestmentHistory(@RequestBody InvestmentHistory investmentHistory) {
        InvestmentHistory createdInvestmentHistory = investmentHistoryService.createInvestmentHistory(investmentHistory);
        return new ResponseEntity<>(createdInvestmentHistory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvestmentHistory> updateInvestmentHistory(@PathVariable Long id, @RequestBody InvestmentHistory investmentHistoryDetails) {
        InvestmentHistory updatedInvestmentHistory = investmentHistoryService.updateInvestmentHistory(id, investmentHistoryDetails);
        return new ResponseEntity<>(updatedInvestmentHistory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestmentHistory(@PathVariable Long id) {
        investmentHistoryService.deleteInvestmentHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}