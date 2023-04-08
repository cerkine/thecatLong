package com.thecatlong.back.application.administracion;

import org.springframework.stereotype.Component;

import com.thecatlong.back.application.provider.out.UsuarioService;
import com.thecatlong.back.domain.Usuario;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UsuarioUseCase {
    private UsuarioService usuarioService;

    public Usuario altaNuevo(Usuario usuario){
        return usuarioService.altaUsuario(usuario);
    }

    public Usuario login(Usuario usuario){
        return usuarioService.login(usuario);
    }
}
