package com.thecatlong.back.application.administracion;

import java.util.List;

import org.springframework.stereotype.Component;

import com.thecatlong.back.application.ValidationUtils;
import com.thecatlong.back.application.provider.out.UsuarioService;
import com.thecatlong.back.domain.Usuario;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UsuarioUseCase {
    private UsuarioService usuarioService;

    public Usuario altaNuevo(Usuario usuario){
        return usuarioService.save(usuario);
    }

    public Usuario login(Usuario usuario){
        return usuarioService.login(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuario();
    }

    public Usuario modificar(Usuario usuario) {
        Usuario validar = usuarioService.getById(usuario.getId());
        ValidationUtils.validateNotNull(validar, "el usuario con id pasada no existe");
        return usuarioService.save(usuario);
    }

    public Usuario getUser(Long id) {
        return usuarioService.getById(id);
    }
}
