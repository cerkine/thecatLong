package com.thecatlong.back.adapter.inbound.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {
    @PostMapping("/prueba")
    public ResponseEntity<String> test(@RequestBody TestModelo modelo) {
        return ResponseEntity.ok(modelo.getNombre());
        
    }
}
