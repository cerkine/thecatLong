package com.thecatlong.back.application.provider.out;

import com.thecatlong.back.domain.Usuario;

public interface UsuarioService {
    Usuario altaUsuario(Usuario usuario);
    Usuario login(Usuario usuario);
}
