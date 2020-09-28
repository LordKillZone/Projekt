package com.example.modulv.repositories;

import com.example.modulv.model.Klient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KlientRepository extends CrudRepository<Klient, Long> {
    Optional<Klient> getKlientByImie(String Imie);
}
