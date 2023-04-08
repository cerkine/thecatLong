package com.thecatlong.back.adapter.inbound.rest.usuario.dto;

import java.util.List;

import lombok.Data;

@Data
public class UsuarioRequest {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String password;
    private List<String> roles;
}
