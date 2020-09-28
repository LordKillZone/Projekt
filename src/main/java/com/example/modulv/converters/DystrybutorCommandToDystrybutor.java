package com.example.modulv.converters;

import com.example.modulv.commands.DystrybutorCommand;
import com.example.modulv.model.Dystrybutor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class DystrybutorCommandToDystrybutor implements Converter<DystrybutorCommand, Dystrybutor> {

    @Synchronized
    @Nullable
    @Override
    public Dystrybutor convert(DystrybutorCommand source) {
        if (source == null) {
            return null;
        }

        final Dystrybutor dystrybutor = new Dystrybutor();
        dystrybutor.setLokalizacja(source.getNazwasalonu());
        dystrybutor.setNazwasalonu(source.getLokalizacja());

        return dystrybutor;
    }
}
