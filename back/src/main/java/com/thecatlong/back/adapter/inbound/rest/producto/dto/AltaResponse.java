package com.thecatlong.back.adapter.inbound.rest.producto.dto;

import lombok.Builder;

public class AltaResponse extends AltaRequest {
    @Builder
    public AltaResponse(String nombre, Double stock, String descripcion, String urlImagen, Long deporteId,
            Double precio, Double descuento, Long tipologiaProductoId) {
        super(nombre, stock, descripcion, urlImagen, deporteId, precio, descuento, tipologiaProductoId);
    }
}
