package com.projeto.curso.web.conversor;

import com.projeto.curso.Service.CargoService;
import com.projeto.curso.domain.Cargo;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import java.lang.annotation.Annotation;
@Component
public class StringToCargoConversor implements Converter<String, Cargo> {
    @Autowired
    private CargoService cargoService;
    @Override
    public Cargo convert(String text) {
        if (text.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(text);
        return cargoService.buscarPorId(id);
    }

}
