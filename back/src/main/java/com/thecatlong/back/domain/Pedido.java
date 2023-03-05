package com.thecatlong.back.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Pedido {
    private final Long id;
    private final boolean activa;
    private final List<Producto> productos;



    // Auditoria fechas unica
    private final LocalDateTime fechaCompra;

    // Auditoria generica
    private final LocalDateTime fechaModificacion;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaBaja;
    private final boolean deleted;
}
