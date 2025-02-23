package com.mateuschaves.GiroProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "investor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("investor")
    private List<InvestmentHistory> investments;

    public Investor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<InvestmentHistory> getInvestments() {
        return investments;
    }

    public void setInvestments(List<InvestmentHistory> investments) {
        this.investments = investments;
    }

    public Investor(String name, String email, List<InvestmentHistory> investments) {
        this.name = name;
        this.email = email;
        this.investments = investments;
    }
}
