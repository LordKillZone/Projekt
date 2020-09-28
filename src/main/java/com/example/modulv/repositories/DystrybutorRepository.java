package com.example.modulv.repositories;

import com.example.modulv.model.Dystrybutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DystrybutorRepository extends CrudRepository<Dystrybutor, Long> {
    Optional<Dystrybutor> getDystrybutorByNazwasalonu(String nazwasalonu);
}
