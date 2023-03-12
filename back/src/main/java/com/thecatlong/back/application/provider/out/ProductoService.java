package com.thecatlong.back.application.provider.out;

import java.util.List;

import com.thecatlong.back.domain.Producto;

public interface ProductoService {
    Producto findById(Long id);
    List<Producto> findByNombre(String nombre);
    List<Producto> findAll();
}
