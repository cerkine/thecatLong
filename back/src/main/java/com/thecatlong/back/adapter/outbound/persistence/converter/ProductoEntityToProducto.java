package com.thecatlong.back.adapter.outbound.persistence.converter;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.thecatlong.back.adapter.outbound.persistence.entity.ProductoEntity;
import com.thecatlong.back.domain.Deporte;
import com.thecatlong.back.domain.Producto;
import com.thecatlong.back.domain.TipologiaProducto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductoEntityToProducto implements Converter<ProductoEntity, Producto>{
    private final ConversionService conversionService;

    @Override
    @Nullable
    public Producto convert(ProductoEntity entity) {
        Deporte deporte = conversionService.convert(entity.getDeporteEntity(),Deporte.class);
        TipologiaProducto tipologiaProducto = conversionService.convert(entity.getTipologiaProductoEntity(), TipologiaProducto.class);
        return Producto.builder()
            .deporte(deporte)
            .tipologiaProducto(tipologiaProducto)
            .nombre(entity.getNombre())
            .descripcion(entity.getDescripcion())
            .id(entity.getId())
            .precio(entity.getPrecio())
            .stock(entity.getStock())
            .urlImagen(entity.getUrlImagen())
            .descuento(entity.getDescuento())
            .build();
    }
    
}
