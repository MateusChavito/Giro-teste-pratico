package com.mateuschaves.GiroProject.controller;


import com.mateuschaves.GiroProject.model.InvestmentHistory;
import com.mateuschaves.GiroProject.service.InvestmentHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/investments")
public class InvestmentHistoryController {

    private final InvestmentHistoryService investmentHistoryService;

    public InvestmentHistoryController(InvestmentHistoryService investmentHistoryService) {
        this.investmentHistoryService = investmentHistoryService;
    }

    @PostMapping
    public ResponseEntity<InvestmentHistory> createInvestment(@RequestBody InvestmentHistory investment) {
        InvestmentHistory createdInvestment = investmentHistoryService.createInvestment(investment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvestment);
    }

    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<InvestmentHistory>> getInvestmentsByInvestor(@PathVariable Long investorId) {
        List<InvestmentHistory> investments = investmentHistoryService.getInvestmentsByInvestor(investorId);
        return ResponseEntity.ok(investments);
    }
}
