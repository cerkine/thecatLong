package com.thecatlong.back.application.provider.out;

import java.util.List;

import com.thecatlong.back.domain.Deporte;

public interface DeporteService {
    Deporte findById(Long id);
    List<Deporte> findByNombre(String nombre);
    List<Deporte> findAll();
}
