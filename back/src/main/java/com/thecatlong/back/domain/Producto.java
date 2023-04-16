package com.thecatlong.back.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Producto {
    @Setter
    private Long id;
    private final String nombre;
    private final Double stock;
    private final String descripcion;
    private final String urlImagen;
    private final Deporte deporte;
    private final Double precio;
    private final Double descuento;
    private final TipologiaProducto tipologiaProducto;
    private final List<Campanya> campanyas;

    // Auditoria generica
    private final LocalDateTime fechaModificacion;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaBaja;
    private final boolean deleted;

}
