package com.example.modulv.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
public class Dystrybutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazwasalonu;
    private String lokalizacja;

    public Dystrybutor(){

    }
    public Dystrybutor (String lokalizacja) {this.lokalizacja = lokalizacja;}
    public Dystrybutor(String nazwasalonu, String lokalizacja) {
        this.nazwasalonu = nazwasalonu;
        this.lokalizacja = lokalizacja;
    }

}
