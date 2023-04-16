package com.thecatlong.back.application.provider.out;

import java.util.List;

import com.thecatlong.back.domain.TipologiaProducto;

public interface TipologiaProductoService {
    List<TipologiaProducto> listarTodos();
    TipologiaProducto getById(Long id);
}
