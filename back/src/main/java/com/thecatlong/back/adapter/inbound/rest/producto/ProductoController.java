package com.thecatlong.back.adapter.inbound.rest.producto;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thecatlong.back.adapter.inbound.rest.producto.dto.AltaRequest;
import com.thecatlong.back.application.producto.ProductoUseCase;
import com.thecatlong.back.domain.Producto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor

public class ProductoController {
    private final ProductoUseCase productoUseCase;
    private final ConversionService conversionService;
    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id){
        Producto d = productoUseCase.searchById(id);
        return ResponseEntity.ok(d);
    }

    @GetMapping("/producto")
    public ResponseEntity<List<Producto>> getProductoByNombre(@PathParam(value = "nombre") String nombre){
        List<Producto> dList = productoUseCase.searchByNombre(nombre);
        return ResponseEntity.ok(dList);
    }

    @PostMapping("/producto")
    public ResponseEntity<Producto> altaProducto(@RequestBody AltaRequest request){
        Producto producto = conversionService.convert(request, Producto.class);
        Producto productoAlta = productoUseCase.alta(producto);
        return ResponseEntity.ok(productoAlta);
    }
}
