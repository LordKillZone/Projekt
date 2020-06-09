package com.example.projektstudia.projektstudia.repositories;

import com.example.projektstudia.projektstudia.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
}
