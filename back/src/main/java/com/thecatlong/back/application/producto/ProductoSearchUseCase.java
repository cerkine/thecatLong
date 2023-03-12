package com.thecatlong.back.application.producto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.thecatlong.back.application.provider.out.ProductoService;
import com.thecatlong.back.domain.Producto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductoSearchUseCase {
    private final ProductoService productoService;
    public List<Producto> searchByNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty())
            return productoService.findByNombre(nombre);
        return productoService.findAll();
    }

    public Producto searchById(Long id) {
        return productoService.findById(id);
    }
}
