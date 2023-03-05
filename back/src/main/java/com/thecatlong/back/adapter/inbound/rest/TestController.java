package com.thecatlong.back.adapter.inbound.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thecatlong.back.adapter.inbound.rest.dto.TestModelo;
import com.thecatlong.back.adapter.inbound.rest.dto.response.ProductoResponse;
import com.thecatlong.back.application.provider.in.TestSearchService;
import com.thecatlong.back.domain.Test;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class TestController {
    private final TestSearchService testSearchService;
    @PostMapping("/prueba")
    public ResponseEntity<ProductoResponse> test(@RequestBody TestModelo modelo) {
        return metodo();
        
    }
    private ResponseEntity<ProductoResponse> metodo() {
        return ResponseEntity.ok(ProductoResponse.builder().deporte(ProductoResponse.Deporte.builder().codigo("furbo").build()).descripcion("pepe").build());
    }
    @GetMapping("/prueba/{id}")
    public ResponseEntity<Test> getById(@PathVariable long id){
        Test t = testSearchService.searchById(id);
        return ResponseEntity.ok(t);
    }

    @GetMapping("/prueba/nombre/{nombre}")
    public ResponseEntity<Test> getByNombre(@PathVariable String nombre){
        Test t = testSearchService.searchByNombre(nombre);
        return ResponseEntity.ok(t);
    }
}
