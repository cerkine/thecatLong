package com.thecatlong.back.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Producto {
    private final Long id;
    private final String nombre;
    private final Double stock;
    private final String descripcion;
    private final String urlImagen;
    private final Deporte deporte;
    private final Double precio;
    private final Double descuento;
    private final TipologiaProducto tipologiaProducto; 

    // Auditoria generica
    private final LocalDateTime fechaModificacion;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaBaja;
    private final boolean deleted;
    
}
