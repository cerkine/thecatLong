package com.thecatlong.back.adapter.inbound.rest.carro;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thecatlong.back.adapter.inbound.rest.carro.dto.AnadirProductoCarroRequest;
import com.thecatlong.back.adapter.inbound.rest.carro.dto.CarroIdResponse;
import com.thecatlong.back.application.carro.CarroUseCase;
import com.thecatlong.back.domain.Carro;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CarroController {
    private final CarroUseCase carroUseCase;

    @Operation (summary = "Anade un producto", description = "Se anade al carro activo si no tiene carro activo se crea")
    @PostMapping("/carro/anadir")
    public ResponseEntity<CarroIdResponse> altaProducto(@RequestBody AnadirProductoCarroRequest request) {
        CarroIdResponse response = CarroIdResponse.builder()
            .id(carroUseCase.addProducto(request.getProductoId(), request.getCantidad(), request.getUsuarioId()))
            .build();
        return ResponseEntity
                .ok(response);
    }

    @Operation (summary = "Recupera un carro por la id del carro")
    @GetMapping("/carro/{id}")
    public ResponseEntity<Carro> getCarro(@PathVariable Long id) {
        return ResponseEntity
                .ok(carroUseCase.getCarro(id));
    }

    @Operation (summary = "Confirma la compra del carro por id del carro")
    @PutMapping("/carro/{id}")
    public ResponseEntity<Carro> comprarCarro(@PathVariable Long id) {
        return ResponseEntity
                .ok(carroUseCase.comprar(id));
    }

    @Operation (summary = "Recupera todos los carros por la id de un usuario")
    @GetMapping("/carro")
    public ResponseEntity<List<Carro>> getCarrosByUser(@RequestParam Long userId) {
            
        return ResponseEntity
                .ok(carroUseCase.getCarrosByUser(userId));
    }

    @Operation (summary = "Recupera el carro activo por la id de usuario")
    @GetMapping("/carro/activo")
    public ResponseEntity<Carro> getCarrosByUserAndActivo(@RequestParam Long userId) {
            
        return ResponseEntity
                .ok(carroUseCase.getCarrosByUserAndActivo(userId));
    }

}
