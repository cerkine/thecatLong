package com.thecatlong.back.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Usuario {
    private final Long id;
    private final String nombre;
    private final String email;
    private final String apellidos;
    // private final String 
    private final List<Pedido> pedidos; 
    private final List<Producto> favoritos;
}
