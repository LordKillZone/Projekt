package com.example.projektstudia.projektstudia.repositories;

import com.example.projektstudia.projektstudia.model.Artist;
import com.example.projektstudia.projektstudia.model.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> getAllByArtistsIsContaining(Artist artist);
}
