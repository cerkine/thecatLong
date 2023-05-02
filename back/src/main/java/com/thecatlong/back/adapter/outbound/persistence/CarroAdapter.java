package com.thecatlong.back.adapter.outbound.persistence;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.thecatlong.back.adapter.inbound.rest.carro.dto.AnadirProductoCarroRequest;
import com.thecatlong.back.adapter.outbound.persistence.entity.CarroEntity;
import com.thecatlong.back.adapter.outbound.persistence.entity.ProductoCarritoEntity;
import com.thecatlong.back.adapter.outbound.persistence.entity.ProductoEntity;
import com.thecatlong.back.adapter.outbound.persistence.entity.UsuarioEntity;
import com.thecatlong.back.adapter.outbound.persistence.repository.CarroRepository;
import com.thecatlong.back.adapter.outbound.persistence.repository.ProductoCarritoRepository;
import com.thecatlong.back.application.provider.out.CarroService;
import com.thecatlong.back.domain.Carro;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarroAdapter implements CarroService {
    private CarroRepository carroRepository;
    private ProductoCarritoRepository productoCarritoRepository;

    @Override
    public Carro addProducto(Long productoId, Long cantidad, Long usuarioId) {
        Optional<CarroEntity> optCarro = carroRepository.findByUsuario_IdAndActivo(usuarioId, true);
        if (optCarro.isPresent()) {
            CarroEntity entity = optCarro.get();
            Iterator<ProductoCarritoEntity> it = productoCarritoRepository.findByCarroId(entity.getId()).iterator();
            boolean anadirPoducto = true;
            while (it.hasNext()) {
                ProductoCarritoEntity entityProductoCarro = it.next();
                ProductoEntity producto = entityProductoCarro.getProducto();
                if (producto.getId().equals(productoId)) {
                    anadirPoducto = false;
                    entityProductoCarro.setCantidad(cantidad);
                    productoCarritoRepository.save(entityProductoCarro);
                    break;
                }
            }

            if (anadirPoducto) {
                addProducto(entity, productoId, cantidad);
            }

        } else {
            CarroEntity entity = CarroEntity.builder()
                    .activo(true)
                    .fechaCreacion(LocalDateTime.now())
                    .usuario(UsuarioEntity.builder().id(usuarioId).build())
                    .build();
            entity = carroRepository.save(entity);
            addProducto(entity, productoId, cantidad);
        }
        return null;
    }

    private void addProducto(CarroEntity entity, Long productoId, Long cantidad) {
        ProductoCarritoEntity addProductEntity = ProductoCarritoEntity.builder()
                .productoId(productoId)
                .carroId(entity.getId()).cantidad(cantidad).build();
        productoCarritoRepository.save(addProductEntity);
    }

}
