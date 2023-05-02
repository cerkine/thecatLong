package com.thecatlong.back.adapter.inbound.rest.carro.dto;

import lombok.Data;

@Data
public class AnadirProductoCarroRequest {
    private final Long usuarioId;
    private final Long cantidad;
    private final Long productoId;
}
