package com.thecatlong.back.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class Usuario {
    @Setter
    private Long id;
    private final String nombre;
    private final String email;
    private final String apellido1;
    private final String apellido2;
    private final String password;
    private final List<String> roles;
    private final List<Carro> carros; 
    private final List<Producto> favoritos;
}
