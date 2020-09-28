package com.example.modulv.repositories;

import com.example.modulv.model.Auto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AutoRepository extends CrudRepository<Auto, Long> {
    Optional<Auto> getFirstByModelAndRprod(String model, String rprod);
    List<Auto> getAllByProducenciId(Auto auto);
}
