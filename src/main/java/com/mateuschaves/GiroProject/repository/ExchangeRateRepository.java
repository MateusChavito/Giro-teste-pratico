package com.mateuschaves.GiroProject.repository;

import com.mateuschaves.GiroProject.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    @Query("SELECT er FROM ExchangeRate er WHERE er.date >= :sevenDaysAgo ORDER BY er.date DESC")
    List<ExchangeRate> findRecentExchangeRates(Date sevenDaysAgo);

    public List<ExchangeRate> findByDateBefore(java.sql.Date date);



}
