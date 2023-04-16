package com.thecatlong.back.adapter.outbound.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.thecatlong.back.adapter.outbound.persistence.entity.UsuarioEntity;
import com.thecatlong.back.adapter.outbound.persistence.repository.UsuarioRepository;
import com.thecatlong.back.application.provider.out.UsuarioService;
import com.thecatlong.back.domain.Usuario;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioAdapter implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ConversionService conversionService;

    @Override
    public Usuario altaUsuario(Usuario usuario) {
        UsuarioEntity entity = conversionService.convert(usuario, UsuarioEntity.class);
        return conversionService.convert(usuarioRepository.save(entity), Usuario.class);
    }

    @Override
    public Usuario login(Usuario usuario) {
        UsuarioEntity entity = conversionService.convert(usuario, UsuarioEntity.class);
        if (entity == null)
            return null;
        Optional<UsuarioEntity> user = usuarioRepository.findByEmailAndPassword(entity.getEmail(),
                entity.getPassword());
        if (user.isPresent()) {
            return conversionService.convert(user.get(), Usuario.class);
        }
        return null;
    }

    @Override
    public List<Usuario> listarUsuario() {
        List<UsuarioEntity> entities = usuarioRepository.findAll();
        return converterListEntityToUsuarioDomain(entities);
    }

    private List<Usuario> converterListEntityToUsuarioDomain(List<UsuarioEntity> entities) {
        List<Usuario> usuarios = new ArrayList<>();
        for (UsuarioEntity entity : entities) {
            usuarios.add(conversionService.convert(entity, Usuario.class));
        }
        return usuarios;
    }

}
