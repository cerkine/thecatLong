package com.thecatlong.back.application.carro;

import org.springframework.stereotype.Component;

import com.thecatlong.back.application.provider.out.CarroService;
import com.thecatlong.back.domain.Carro;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CarroUseCase {
    private final CarroService carroService;

    public Carro addProducto(Long productoId, Long cantidad, Long usuarioId){
        return carroService.addProducto(productoId, cantidad, usuarioId);
    }
    
}
