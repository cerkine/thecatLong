package com.thecatlong.back.adapter.inbound.rest.carro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thecatlong.back.adapter.inbound.rest.carro.dto.AnadirProductoCarroRequest;
import com.thecatlong.back.application.carro.CarroUseCase;
import com.thecatlong.back.domain.Carro;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CarroController {
    private final CarroUseCase carroUseCase;

    @PostMapping("/carro/anadir")
    public ResponseEntity<Carro> altaProducto(@RequestBody AnadirProductoCarroRequest request) {

        return ResponseEntity
                .ok(carroUseCase.addProducto(request.getProductoId(), request.getCantidad(), request.getUsuarioId()));
    }

}
