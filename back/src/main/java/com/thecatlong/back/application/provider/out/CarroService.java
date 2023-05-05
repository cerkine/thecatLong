package com.thecatlong.back.application.provider.out;

import java.util.List;

import com.thecatlong.back.domain.Carro;

public interface CarroService {
    
    Long addProducto(Long productoId, Long cantidad, Long usuarioId);

    Carro getCarro(Long id);

    List<Carro> getCarrosByUser(Long userId);

    Carro getCarrosByUserAndActivo(Long userId);

    Carro comprar(Long id);

}
