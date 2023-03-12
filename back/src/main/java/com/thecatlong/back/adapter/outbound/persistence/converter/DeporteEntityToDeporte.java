package com.thecatlong.back.adapter.outbound.persistence.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.thecatlong.back.adapter.outbound.persistence.entity.DeporteEntity;
import com.thecatlong.back.domain.Deporte;

@Component
public class DeporteEntityToDeporte implements Converter<DeporteEntity, Deporte> {

    @Override
    @Nullable
    public Deporte convert(DeporteEntity entity) {
        return Deporte.builder()
                .codigo(entity.getCodigo())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .id(entity.getId()).build();
    }

}
