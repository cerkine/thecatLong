package com.thecatlong.back.application.provider.out;

import com.thecatlong.back.domain.Carro;

public interface CarroService {
    
    Carro addProducto(Long productoId, Long cantidad, Long usuarioId);
}
