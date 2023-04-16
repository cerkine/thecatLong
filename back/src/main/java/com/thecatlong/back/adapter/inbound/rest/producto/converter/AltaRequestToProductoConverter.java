package com.thecatlong.back.adapter.inbound.rest.producto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.thecatlong.back.adapter.inbound.rest.producto.dto.AltaRequest;
import com.thecatlong.back.domain.Deporte;
import com.thecatlong.back.domain.Producto;
import com.thecatlong.back.domain.TipologiaProducto;

@Component
public class AltaRequestToProductoConverter implements Converter<AltaRequest, Producto>{

    @Override
    @Nullable
    public Producto convert(AltaRequest request) {
        Deporte deporte = Deporte.builder()
            .id(request.getDeporteId())
            .build();
        TipologiaProducto tipologiaProducto = TipologiaProducto.builder()
            .id(request.getTipologiaProductoId())
            .build();
        return Producto.builder()
            .deporte(deporte)
            .tipologiaProducto(tipologiaProducto)
            .descripcion(request.getDescripcion())
            .nombre(request.getNombre())
            .urlImagen(request.getUrlImagen())
            .descuento(request.getDescuento())
            .precio(request.getPrecio())
            .stock(request.getStock())
            .build();
    }
    
}
