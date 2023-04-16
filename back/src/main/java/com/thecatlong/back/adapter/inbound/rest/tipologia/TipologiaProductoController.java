package com.thecatlong.back.adapter.inbound.rest.tipologia;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thecatlong.back.application.tipologia.TipologiaProductoUseCase;
import com.thecatlong.back.domain.TipologiaProducto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class TipologiaProductoController {
    private final TipologiaProductoUseCase tipologiaProductoUseCase;

    @GetMapping("/tipologia/producto")
    public ResponseEntity<List<TipologiaProducto>> getAll(){
        List<TipologiaProducto> dList = tipologiaProductoUseCase.listarTodos();
        return ResponseEntity.ok(dList);
    }
    
}
