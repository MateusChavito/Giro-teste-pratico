package com.mateuschaves.GiroProject.service;

import com.mateuschaves.GiroProject.model.InvestmentHistory;
import com.mateuschaves.GiroProject.repository.InvestmentHistoryRepository;
import com.mateuschaves.GiroProject.repository.CurrencyRepository;
import com.mateuschaves.GiroProject.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class InvestmentHistoryService {

    private final InvestmentHistoryRepository investmentHistoryRepository;
    private final CurrencyRepository currencyRepository;
    private final InvestorRepository investorRepository;

    public InvestmentHistoryService(InvestmentHistoryRepository investmentHistoryRepository,
                                    CurrencyRepository currencyRepository,
                                    InvestorRepository investorRepository) {
        this.investmentHistoryRepository = investmentHistoryRepository;
        this.currencyRepository = currencyRepository;
        this.investorRepository = investorRepository;
    }

    private BigDecimal calculateFinalAmount(BigDecimal initialAmount, int months, BigDecimal interestRate) {
        BigDecimal rate = interestRate.divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
        BigDecimal finalAmount = initialAmount.multiply(BigDecimal.ONE.add(rate).pow(months));
        return finalAmount.setScale(2, RoundingMode.HALF_UP);
    }

    public InvestmentHistory createInvestmentHistory(InvestmentHistory investmentHistory) {

        if (!investorRepository.existsById(investmentHistory.getInvestor().getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Investidor não encontrado");
        }
        if (!currencyRepository.existsById(investmentHistory.getCurrency().getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moeda não encontrada");
        }


        BigDecimal finalAmount = calculateFinalAmount(investmentHistory.getInitialAmount(),
                investmentHistory.getMonths(), investmentHistory.getInterestRate());

        investmentHistory.setFinalAmount(finalAmount);

        return investmentHistoryRepository.save(investmentHistory);
    }

    public InvestmentHistory updateInvestmentHistory(Long id, InvestmentHistory investmentHistoryDetails) {
        InvestmentHistory existingInvestmentHistory = investmentHistoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O Histórico de investimento não foi encontrado."));

        existingInvestmentHistory.setInitialAmount(investmentHistoryDetails.getInitialAmount());
        existingInvestmentHistory.setMonths(investmentHistoryDetails.getMonths());
        existingInvestmentHistory.setInterestRate(investmentHistoryDetails.getInterestRate());

        BigDecimal finalAmount = calculateFinalAmount(existingInvestmentHistory.getInitialAmount(),
                existingInvestmentHistory.getMonths(), existingInvestmentHistory.getInterestRate());
        existingInvestmentHistory.setFinalAmount(finalAmount);

        return investmentHistoryRepository.save(existingInvestmentHistory);
    }

    public void deleteInvestmentHistory(Long id) {
        InvestmentHistory existingInvestmentHistory = investmentHistoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "O Histórico de investimento não foi encontrado!"));
        investmentHistoryRepository.delete(existingInvestmentHistory);
    }
}
