package com.example.modulv.repositories;

import com.example.modulv.model.Auto;
import com.example.modulv.model.Producent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProducentRepository extends CrudRepository<Producent, Long> {

    List<Auto> getAllByAutaIsContaining(Auto auto);
}
