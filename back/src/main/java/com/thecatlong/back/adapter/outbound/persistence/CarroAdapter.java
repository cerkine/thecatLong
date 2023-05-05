package com.thecatlong.back.adapter.outbound.persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.jni.Local;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.thecatlong.back.adapter.inbound.rest.carro.dto.AnadirProductoCarroRequest;
import com.thecatlong.back.adapter.outbound.persistence.entity.CarroEntity;
import com.thecatlong.back.adapter.outbound.persistence.entity.ProductoCarritoEntity;
import com.thecatlong.back.adapter.outbound.persistence.entity.ProductoEntity;
import com.thecatlong.back.adapter.outbound.persistence.entity.UsuarioEntity;
import com.thecatlong.back.adapter.outbound.persistence.repository.CarroRepository;
import com.thecatlong.back.adapter.outbound.persistence.repository.ProductoCarritoRepository;
import com.thecatlong.back.application.provider.out.CarroService;
import com.thecatlong.back.domain.Carro;
import com.thecatlong.back.domain.Deporte;
import com.thecatlong.back.domain.Producto;
import com.thecatlong.back.domain.TipologiaProducto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarroAdapter implements CarroService {
    private CarroRepository carroRepository;
    private ProductoCarritoRepository productoCarritoRepository;
    private final ConversionService converter;

    @Override
    public Long addProducto(Long productoId, Long cantidad, Long usuarioId) {
        Optional<CarroEntity> optCarro = carroRepository.findByUsuario_IdAndActivo(usuarioId, true);
        CarroEntity entity;
        if (optCarro.isPresent()) {
            entity = optCarro.get();
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
            entity.setFechaModificacion(LocalDateTime.now());
            entity = carroRepository.save(entity);

        } else {
            entity = CarroEntity.builder()
                    .activo(true)
                    .fechaCreacion(LocalDateTime.now())
                    .usuario(UsuarioEntity.builder().id(usuarioId).build())
                    .build();
            entity = carroRepository.save(entity);
            addProducto(entity, productoId, cantidad);
        }
        return entity.getId();
    }

    private void addProducto(CarroEntity entity, Long productoId, Long cantidad) {
        ProductoCarritoEntity addProductEntity = ProductoCarritoEntity.builder()
                .productoId(productoId)
                .carroId(entity.getId()).cantidad(cantidad).build();
        productoCarritoRepository.save(addProductEntity);
    }

    @Override
    public Carro getCarro(Long id) {

        Optional<CarroEntity> optEntity = carroRepository.findById(id);
        return extaerDatosCarroEntity(optEntity);

    }

    @Override
    public List<Carro> getCarrosByUser(Long userId) {
        List<CarroEntity> optCarro = carroRepository.findByUsuario_Id(userId);
        return extaerDatosCarroEntityList(optCarro);

    }

    private List<Carro> extaerDatosCarroEntityList(List<CarroEntity> list) {
        List<Carro> carros = new ArrayList<>();

        for (CarroEntity carroEntity : list) {
            Optional<CarroEntity> optional = Optional.of(carroEntity);
            Carro c = extaerDatosCarroEntity(optional);
            if (c != null)
                carros.add(c);
        }

        return carros;
    }

    private Carro extaerDatosCarroEntity(Optional<CarroEntity> optional) {
        if (!optional.isPresent())
            return null;

        CarroEntity entity = optional.get();

        Iterator<ProductoCarritoEntity> productosEntitys = productoCarritoRepository.findByCarroId(entity.getId())
                .iterator();

        return toDomain(entity, productosEntitys);
    }

    private Carro toDomain(CarroEntity entity, Iterator<ProductoCarritoEntity> it) {
        List<Producto> productos = new ArrayList<>();
        Double totalCarro = 0D;

        while (it.hasNext()) {
            ProductoCarritoEntity pEntity = it.next();
            Producto p = Producto.builder()
                    .deporte(converter.convert(pEntity.getProducto().getDeporteEntity(), Deporte.class))
                    .descripcion(pEntity.getProducto().getDescripcion())
                    .nombre(pEntity.getProducto().getNombre())
                    .urlImagen(pEntity.getProducto().getUrlImagen())
                    .id(pEntity.getProducto().getId())
                    .precio(pEntity.getProducto().getPrecio())
                    .cantidad(pEntity.getCantidad())
                    .tipologiaProducto(converter.convert(pEntity.getProducto().getTipologiaProductoEntity(),
                            TipologiaProducto.class))
                    .build();
            totalCarro += p.getPrecio() * p.getCantidad();
            productos.add(p);
        }

        Carro c = Carro.builder()
                .activo(entity.isActivo())
                .productos(productos)
                .total(totalCarro)
                .fechaCompra(entity.getFechaCompra())
                .fechaCreacion(entity.getFechaCreacion())
                .fechaModificacion(entity.getFechaModificacion())
                .id(entity.getId())
                .build();

        return c;
    }

    @Override
    public Carro getCarrosByUserAndActivo(Long userId) {
        Optional<CarroEntity> optional = carroRepository.findByUsuario_IdAndActivo(userId, true);
        return extaerDatosCarroEntity(optional);
    }

    @Override
    public Carro comprar(Long id) {
        Optional<CarroEntity> optional = carroRepository.findByIdAndActivo(id, true);
        if (!optional.isPresent())
            throw new HttpClientErrorException(HttpStatus.NOT_ACCEPTABLE);

        CarroEntity entity = optional.get();

        entity.setFechaCompra(LocalDateTime.now());
        entity.setActivo(false);
        entity = carroRepository.save(entity);

        optional = Optional.of(entity);

        return extaerDatosCarroEntity(optional);
    }

}
