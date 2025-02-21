package com.mateuschaves.GiroProject.controller;

import com.mateuschaves.GiroProject.model.Investor;
import com.mateuschaves.GiroProject.repository.InvestorRepository;
import org.hibernate.query.NativeQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/investors")
public class InvestorController {

    private final InvestorRepository investorRepository;

    public InvestorController(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    @GetMapping
    public List<Investor> getAllInvestors(){
        return investorRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Investor> createInvestor(@RequestBody Investor investor) {
        Investor savedInvestor = investorRepository.save(investor);
        return new ResponseEntity<>(savedInvestor, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Investor>updateInvestor(@PathVariable Long id, @RequestBody Investor investorDetails){
        Optional<Investor> investorOptional = investorRepository.findById(id);
        if(investorOptional.isPresent()){
            Investor investor = investorOptional.get();
            investor.setName(investorDetails.getName());
            investor.setEmail(investorDetails.getEmail());
            investorRepository.save(investor);

            return new ResponseEntity<>(investor, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteInvestor(@PathVariable Long id){
        if(investorRepository.existsById(id)){
            investorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}
