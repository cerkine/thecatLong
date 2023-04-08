package com.thecatlong.back.adapter.outbound.persistence.converter;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.thecatlong.back.adapter.outbound.persistence.entity.UsuarioEntity;
import com.thecatlong.back.domain.Usuario;

@Component
public class UsuarioEntityToUsuario implements Converter<UsuarioEntity, Usuario> {

    @Override
    @Nullable
    public Usuario convert(UsuarioEntity entity) {
        return Usuario.builder()
                .apellido1(entity.getApellido1())
                .apellido2(entity.getApellido2())
                .email(entity.getEmail())
                .nombre(entity.getNombre())
                .id(entity.getId())
                .password(entity.getPassword())
                .roles(entity.getRoles() != null
                        ? new ArrayList<String>(Arrays.asList(entity.getRoles().split(",")))
                        : null)
                .build();
    }

}
