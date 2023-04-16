package com.thecatlong.back.application.provider.out;

import java.util.List;

import com.thecatlong.back.domain.Usuario;

public interface UsuarioService {
    Usuario altaUsuario(Usuario usuario);
    Usuario login(Usuario usuario);
    List<Usuario> listarUsuario();
}
