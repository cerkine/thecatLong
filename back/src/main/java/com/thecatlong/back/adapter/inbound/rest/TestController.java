package com.thecatlong.back.adapter.inbound.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thecatlong.back.adapter.inbound.rest.dto.TestModelo;
import com.thecatlong.back.application.provider.in.TestSearchService;
import com.thecatlong.back.domain.Test;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class TestController {
    private final TestSearchService testSearchService;
    @PostMapping("/prueba")
    public ResponseEntity<String> test(@RequestBody TestModelo modelo) {
        return ResponseEntity.ok(modelo.getNombre());
        
    }
    @GetMapping("/prueba/{id}")
    public ResponseEntity<Test> getById(@PathVariable long id){
        Test t = testSearchService.searchById(id);
        return ResponseEntity.ok(t);
    }
}
