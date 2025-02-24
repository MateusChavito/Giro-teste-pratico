package com.mateuschaves.GiroProject.service;

import com.mateuschaves.GiroProject.model.Investor;
import com.mateuschaves.GiroProject.repository.InvestorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class InvestorService {

    private final InvestorRepository investorRepository;

    public InvestorService(InvestorRepository investorRepository){
        this.investorRepository = investorRepository;
    }

    public List<Investor>getAllInvestors(){
        return investorRepository.findAll();
    }

    public Investor getInvestorById(Long id){
        return investorRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Investidor não foi encontrado!"));
    }

    public Investor createInvestor(Investor investor){
        if(investorRepository.existsByEmail(investor.getEmail())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já está cadastrado!");
        }
        return  investorRepository.save(investor);
    }

    public Investor updateInvestor(Long id, Investor investorDetails){
        Investor investor = getInvestorById(id);
        investor.setName(investorDetails.getName());
        investor.setEmail(investorDetails.getEmail());
        return investorRepository.save(investor);
    }

    public void deleteInvestor(Long id){
        Investor investor = getInvestorById(id);
        investorRepository.delete(investor);
    }




}
