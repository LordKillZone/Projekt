package com.example.projektstudia.projektstudia.converters;

import com.example.projektstudia.projektstudia.commands.PublisherCommand;
import com.example.projektstudia.projektstudia.model.Publisher;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PublisherCommandToPublisher implements Converter<PublisherCommand, Publisher> {
    @Synchronized
    @Nullable
    @Override
    public Publisher convert(PublisherCommand source){
        if (source == null) {
            return null;
        }
        final Publisher publisher = new Publisher();
        publisher.setName(source.getName());
        publisher.setNip(source.getNip());
        publisher.setAddress(source.getAddress());

        return publisher;
    }
}
