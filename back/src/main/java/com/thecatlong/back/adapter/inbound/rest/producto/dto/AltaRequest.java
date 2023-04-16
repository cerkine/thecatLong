package com.thecatlong.back.adapter.inbound.rest.producto.dto;

import lombok.Data;

@Data
public class AltaRequest {
    private final String nombre;
    private final Double stock;
    private final String descripcion;
    private final String urlImagen;
    private final Long deporteId;
    private final Double precio;
    private final Double descuento;
    private final Long tipologiaProductoId;
}
