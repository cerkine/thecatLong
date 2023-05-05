package com.thecatlong.back.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(Include.NON_NULL)
public class Carro {
    // id producto, cantidad
    private Long id;
    List<Producto> productos;

    private boolean activo;

    private Double total;

    
    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaModificacion;

    private LocalDateTime fechaCompra;

    
}
