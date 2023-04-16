package com.thecatlong.back.application.provider.out;

import java.util.List;

import com.thecatlong.back.domain.Usuario;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    Usuario login(Usuario usuario);
    List<Usuario> listarUsuario();
    Usuario getById(Long id);
}
