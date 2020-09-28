package com.example.modulv.converters;

import com.example.modulv.commands.AutoCommand;
import com.example.modulv.model.Auto;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class AutoCommandToAuto implements Converter<AutoCommand, Auto> {

    @Synchronized
    @Nullable
    @Override
    public Auto convert(AutoCommand source) {
        if (source == null) {
            return null;
        }

        final Auto auto = new Auto();
        auto.setModel(source.getModel());
        auto.setRprod(source.getRprod());
        auto.setPaliwo(source.getPaliwo());

        return auto;
    }
}
