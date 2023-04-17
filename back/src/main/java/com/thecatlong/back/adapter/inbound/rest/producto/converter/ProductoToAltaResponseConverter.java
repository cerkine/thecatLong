package com.thecatlong.back.adapter.inbound.rest.producto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.thecatlong.back.adapter.inbound.rest.producto.dto.AltaResponse;
import com.thecatlong.back.domain.Producto;

@Component
public class ProductoToAltaResponseConverter implements Converter<Producto, AltaResponse>{

    @Override
    @Nullable
    public AltaResponse convert(Producto producto) {
        return AltaResponse.builder()
            .deporteId(producto.getDeporte().getId())
            .descripcion(producto.getDescripcion())
            .descuento(producto.getDescuento())
            .nombre(producto.getNombre())
            .urlImagen(producto.getUrlImagen())
            .precio(producto.getPrecio())
            .stock(producto.getStock())
            .tipologiaProductoId(producto.getTipologiaProducto().getId())
            .build();
    }
    
}
