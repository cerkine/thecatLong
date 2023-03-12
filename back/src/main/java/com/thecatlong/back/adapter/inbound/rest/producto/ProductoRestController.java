package com.thecatlong.back.adapter.inbound.rest.producto;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thecatlong.back.application.producto.ProductoSearchUseCase;
import com.thecatlong.back.domain.Producto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor

public class ProductoRestController {
    private final ProductoSearchUseCase productoSearchUseCase;
    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> getDeporteById(@PathVariable Long id){
        Producto d = productoSearchUseCase.searchById(id);
        return ResponseEntity.ok(d);
    }

    @GetMapping("/producto")
    public ResponseEntity<List<Producto>> getDeporteByNombre(@PathParam(value = "nombre") String nombre){
        List<Producto> dList = productoSearchUseCase.searchByNombre(nombre);
        return ResponseEntity.ok(dList);
    }
}
