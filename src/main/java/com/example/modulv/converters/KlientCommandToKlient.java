package com.example.modulv.converters;

import com.example.modulv.commands.KlientCommand;
import com.example.modulv.model.Klient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class KlientCommandToKlient implements Converter<KlientCommand, Klient> {
    @Synchronized
    @Nullable
    @Override
    public Klient convert(KlientCommand source) {
        if (source == null) {
            return null;
        }

        final Klient klient = new Klient();
        klient.setImie(source.getImie());
        klient.setNazwisko(source.getNazwisko());

        return klient;
    }
}
