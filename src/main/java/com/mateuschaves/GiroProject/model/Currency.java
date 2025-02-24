package com.mateuschaves.GiroProject.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String type;

    public Currency() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Currency( String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
