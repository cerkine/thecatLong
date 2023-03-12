package com.thecatlong.back.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
@JsonInclude(Include.NON_NULL)
public class TipologiaProducto {
    private final Long id;
    private final String codigo;
    private final String nombre;
    private final String descripcion;

}
