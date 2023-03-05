package com.thecatlong.back.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class TipologiaProducto {
    private final Long id;
    private final String codigo;
    private final String nombre;
    private final String descripcion;

}
