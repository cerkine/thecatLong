package com.thecatlong.back.application.tipologia;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thecatlong.back.application.provider.out.TipologiaProductoService;
import com.thecatlong.back.domain.TipologiaProducto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipologiaProductoUseCase {
    private final TipologiaProductoService tipologiaProductoService;

    public List<TipologiaProducto> listarTodos() {
        return tipologiaProductoService.listarTodos();
    }
}
