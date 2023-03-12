package com.thecatlong.back.adapter.outbound.persistence.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.thecatlong.back.adapter.outbound.persistence.entity.TipologiaProductoEntity;
import com.thecatlong.back.domain.TipologiaProducto;

@Component
public class TipologiaProductoEntityToTipologiaProducto
        implements Converter<TipologiaProductoEntity, TipologiaProducto> {

    @Override
    @Nullable
    public TipologiaProducto convert(TipologiaProductoEntity entity) {
        return TipologiaProducto.builder()
                .codigo(entity.getCodigo())
                .descripcion(entity.getDescripcion())
                .id(entity.getId())
                .build();
    }

}
