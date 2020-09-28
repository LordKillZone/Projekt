package com.example.modulv.converters;

import com.example.modulv.commands.ProducentCommand;
import com.example.modulv.model.Auto;
import com.example.modulv.model.Dystrybutor;
import com.example.modulv.model.Producent;
import com.example.modulv.repositories.AutoRepository;
import com.example.modulv.repositories.DystrybutorRepository;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProducentCommandToProducent implements Converter<ProducentCommand, Producent> {

    private DystrybutorRepository dystrybutorRepository;
    private AutoRepository autoRepository;

    public ProducentCommandToProducent(DystrybutorRepository dystrybutorRepository, AutoRepository autoRepository) {
        this.dystrybutorRepository = dystrybutorRepository;
        this.autoRepository = autoRepository;
    }

    @Synchronized
    @Nullable
    @Override
    public Producent convert(ProducentCommand source) {
        if (source == null) {
            return null;
        }

        final Producent producent = new Producent();
        producent.setId(source.getId());
        producent.setMarka(source.getMarka());
        producent.setLokalizacja(source.getLokalizacja());
        producent.setNrstanowiska(source.getNrstanowiska());

        Optional<Dystrybutor> dystrybutor = dystrybutorRepository.findById(source.getDystrybutorId());

        if (dystrybutor.isPresent()) {
            producent.setDystrybutor(dystrybutor.get());
        }
        else {
            producent.setDystrybutor(dystrybutorRepository.getDystrybutorByNazwasalonu("nieznane").get());
        }

        Optional<Auto> auto = autoRepository.findById(source.getAutoId());

        if (auto.isPresent()) {
            producent.getAuta().add(auto.get());
        }
        return producent;
    }
}
