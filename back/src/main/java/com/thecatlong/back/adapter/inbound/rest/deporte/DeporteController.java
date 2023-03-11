package com.thecatlong.back.adapter.inbound.rest.deporte;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thecatlong.back.application.deporte.DeporteSearchUseCase;
import com.thecatlong.back.domain.Deporte;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class DeporteController {
    private final DeporteSearchUseCase deporteSearchUseCase;
    @GetMapping("/deporte/{id}")
    public ResponseEntity<Deporte> getDeporteById(@PathVariable Long id){
        Deporte d = deporteSearchUseCase.searchById(id);
        return ResponseEntity.ok(d);
    }

    @GetMapping("/deporte")
    public ResponseEntity<List<Deporte>> getDeporteByNombre(@PathParam(value = "nombre") String nombre){
        List<Deporte> dList = deporteSearchUseCase.searchByNombre(nombre);
        return ResponseEntity.ok(dList);
    }
}
