package com.thecatlong.back.application.carro;

import java.util.List;

import org.springframework.stereotype.Component;

import com.thecatlong.back.application.provider.out.CarroService;
import com.thecatlong.back.domain.Carro;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CarroUseCase {
    private final CarroService carroService;

    public Long addProducto(Long productoId, Long cantidad, Long usuarioId){
        return carroService.addProducto(productoId, cantidad, usuarioId);
    }

    public Carro getCarro(Long id) {
        return carroService.getCarro(id);
    }

    public List<Carro> getCarrosByUser(Long userId) {
        return carroService.getCarrosByUser(userId);
    }

    public Carro getCarrosByUserAndActivo(Long userId) {
        return carroService.getCarrosByUserAndActivo(userId);
    }

    public Carro comprar(Long id) {
        return carroService.comprar(id);
    }
    
}
