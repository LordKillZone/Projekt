package com.example.projektstudia.projektstudia.repositories;

import com.example.projektstudia.projektstudia.model.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    Optional<Publisher> getPublisherByName(String name);
}
