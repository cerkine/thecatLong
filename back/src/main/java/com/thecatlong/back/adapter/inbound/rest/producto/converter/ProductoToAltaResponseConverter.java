package com.thecatlong.back.adapter.inbound.rest.producto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.thecatlong.back.adapter.inbound.rest.producto.dto.ProductoResponse;
import com.thecatlong.back.domain.Producto;

@Component
public class ProductoToAltaResponseConverter implements Converter<Producto, ProductoResponse>{

    @Override
    @Nullable
    public ProductoResponse convert(Producto producto) {
        return ProductoResponse.builder()
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
