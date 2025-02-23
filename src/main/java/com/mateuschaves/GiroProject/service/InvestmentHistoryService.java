package com.mateuschaves.GiroProject.service;

import com.mateuschaves.GiroProject.model.InvestmentHistory;
import com.mateuschaves.GiroProject.repository.InvestmentHistoryRepository;
import com.mateuschaves.GiroProject.repository.CurrencyRepository;
import com.mateuschaves.GiroProject.repository.InvestorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

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
        return initialAmount.multiply(BigDecimal.ONE.add(rate).pow(months)).setScale(2, RoundingMode.HALF_UP);
    }

    public InvestmentHistory createInvestment(InvestmentHistory investment) {
        if (!investorRepository.existsById(investment.getInvestor().getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Investidor não encontrado");
        }
        if (!currencyRepository.existsById(investment.getCurrency().getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Moeda não encontrada");
        }

        investment.setFinalAmount(calculateFinalAmount(investment.getInitialAmount(), investment.getMonths(), investment.getInterestRate()));
        return investmentHistoryRepository.save(investment);
    }

    public List<InvestmentHistory> getInvestmentsByInvestor(Long investorId) {
        if (!investorRepository.existsById(investorId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Investidor não encontrado");
        }
        return investmentHistoryRepository.findByInvestorId(investorId);
    }
}
