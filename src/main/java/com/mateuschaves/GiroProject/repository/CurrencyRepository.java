package com.mateuschaves.GiroProject.repository;


import com.mateuschaves.GiroProject.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {



}
