package com.thecatlong.back.adapter.inbound.rest.usuario;

import java.util.List;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thecatlong.back.adapter.inbound.rest.usuario.dto.UsuarioRequest;
import com.thecatlong.back.application.administracion.UsuarioUseCase;
import com.thecatlong.back.domain.Usuario;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioUseCase usuarioUseCase;
    private final ConversionService conversionService;

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> altaUsuario(@RequestBody UsuarioRequest request){
        Usuario usuario = conversionService.convert(request, Usuario.class);
        return ResponseEntity.ok(usuarioUseCase.altaNuevo(usuario));
    }

    @PostMapping("/usuario/{id}")
    public ResponseEntity<Usuario> modificar(@PathVariable Long id, @RequestBody UsuarioRequest request){
        Usuario usuario = conversionService.convert(request, Usuario.class);
        usuario.setId(id);
        return ResponseEntity.ok(usuarioUseCase.modificar(usuario));
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.ok(usuarioUseCase.listarUsuarios());
    }

    @PostMapping("/usuario/login")
    public ResponseEntity<Usuario> login(@RequestParam String email, @RequestParam String password){
        Usuario usuario = Usuario.builder().email(email).password(password).build();
        usuario = usuarioUseCase.login(usuario);
        if (usuario != null){
            return ResponseEntity.ok(usuario);
        }else {
            return ResponseEntity.status(401).build();
        }
    }
}
