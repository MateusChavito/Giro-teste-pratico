package com.mateuschaves.GiroProject.repository;

import com.mateuschaves.GiroProject.model.InvestmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestmentHistoryRepository extends JpaRepository<InvestmentHistory, Long> {
    List<InvestmentHistory> findByInvestorId(Long investorId);

}
