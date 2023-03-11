package com.thecatlong.back.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Campanya {
    private final Long id;
    private final String nombre;
    private final String descripcion;
    private final LocalDateTime fechaInicio;
    private final LocalDateTime fechaFin;
}
