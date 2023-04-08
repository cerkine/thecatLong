package com.thecatlong.back.adapter.inbound.rest.usuario.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.thecatlong.back.adapter.inbound.rest.usuario.dto.UsuarioRequest;
import com.thecatlong.back.domain.Usuario;

@Component
public class UsuarioRequestToUsuario implements Converter<UsuarioRequest, Usuario>{

    @Override
    @Nullable
    public Usuario convert(UsuarioRequest request) {
        return Usuario.builder()
            .apellido1(request.getApellido1())
            .apellido2(request.getApellido2())
            .email(request.getEmail())
            .nombre(request.getNombre())
            .password(request.getPassword())
            .roles(request.getRoles())
            .build();
    }
    
}
