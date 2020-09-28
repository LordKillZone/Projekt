package com.example.modulv.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
public class Producent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marka;
    private String lokalizacja;
    private String nrstanowiska;

    @ManyToOne
    private Dystrybutor dystrybutor;


    @ManyToMany
    private Set<Producent> auta = new HashSet<>();

    public Producent(String marka, String lokalizacja, String nrstanowiska, Dystrybutor dystrybutor) {
        this.marka = marka;
        this.lokalizacja = lokalizacja;
        this.nrstanowiska = nrstanowiska;
        this.dystrybutor = dystrybutor;
    }

}
