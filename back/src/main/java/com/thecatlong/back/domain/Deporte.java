package com.thecatlong.back.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Deporte {
    private final Long id;
    private final String codigo;
    private final String nombre;
    private final String descripcion;

    // Auditoria generica
    private final LocalDateTime fechaModificacion;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaBaja;
    private final boolean deleted;

}
