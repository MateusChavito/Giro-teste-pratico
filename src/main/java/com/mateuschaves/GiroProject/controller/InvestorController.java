package com.mateuschaves.GiroProject.controller;

import com.mateuschaves.GiroProject.model.Investor;
import com.mateuschaves.GiroProject.repository.InvestorRepository;
import com.mateuschaves.GiroProject.service.InvestorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investors")
public class InvestorController {

    private final InvestorService investorService;

    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }

    @GetMapping
    public ResponseEntity<List<Investor>> getAllInvestors() {
        return ResponseEntity.ok(investorService.getAllInvestors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investor>getInvestorById(@PathVariable Long id){
        return ResponseEntity.ok(investorService.getInvestorById(id));
    }

    @PostMapping
    public ResponseEntity<Investor> createInvestor(@RequestBody Investor investor) {
        return ResponseEntity.status(201).body(investorService.createInvestor(investor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investor>updateInvestor(@PathVariable Long id, @RequestBody Investor investor){
        return ResponseEntity.ok(investorService.updateInvestor(id, investor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteInvestor(@PathVariable Long id) {
        investorService.deleteInvestor(id);
        return ResponseEntity.noContent().build();

    }


}
