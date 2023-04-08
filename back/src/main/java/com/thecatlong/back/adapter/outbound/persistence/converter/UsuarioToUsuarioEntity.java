package com.thecatlong.back.adapter.outbound.persistence.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.thecatlong.back.adapter.outbound.persistence.entity.UsuarioEntity;
import com.thecatlong.back.domain.Usuario;

@Component
public class UsuarioToUsuarioEntity implements Converter<Usuario, UsuarioEntity> {

    @Override
    @Nullable
    public UsuarioEntity convert(Usuario domain) {
        return UsuarioEntity.builder()
            .email(domain.getEmail())
            .nombre(domain.getNombre())
            .password(domain.getPassword())
            .apellido1(domain.getApellido1())
            .apellido2(domain.getApellido2())
            .roles(domain.getRoles() != null ? String.join(",", domain.getRoles()) : null)
            .build();
    }
}
