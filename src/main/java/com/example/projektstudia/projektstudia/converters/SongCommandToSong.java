package com.example.projektstudia.projektstudia.converters;

import com.example.projektstudia.projektstudia.commands.SongCommand;
import com.example.projektstudia.projektstudia.model.Artist;
import com.example.projektstudia.projektstudia.model.Publisher;
import com.example.projektstudia.projektstudia.model.Song;
import com.example.projektstudia.projektstudia.repositories.ArtistRepository;
import com.example.projektstudia.projektstudia.repositories.PublisherRepository;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class SongCommandToSong implements Converter<SongCommand, Song> {

    private PublisherRepository publisherRepository;
    private ArtistRepository artistRepository;

    public SongCommandToSong(PublisherRepository publisherRepository, ArtistRepository artistRepository) {
        this.publisherRepository = publisherRepository;
        this.artistRepository = artistRepository;
    }

    @Synchronized
    @Nullable
    @Override
    public Song convert(SongCommand source) {
        if (source == null) {
            return null;
        }

        final Song song = new Song();
        song.setId(source.getId());
        song.setTitle(source.getTitle());
        song.setGenre(source.getGenre());
        song.setYear(source.getYear());
        song.setIsmn(source.getIsmn());

        Optional<Publisher> publisher = publisherRepository.findById(source.getPublisherId());

        if (publisher.isPresent()) {
            song.setPublisher(publisher.get());
        } else {
            song.setPublisher(publisherRepository.getPublisherByName("Unknown").get());
        }

        Optional<Artist> artist = artistRepository.findById(source.getArtistId());

        if (artist.isPresent()) {
            song.getArtists().add(artist.get());
        }

        return song;
    }
}

