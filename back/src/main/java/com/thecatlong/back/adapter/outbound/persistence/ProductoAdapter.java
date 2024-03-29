package com.thecatlong.back.adapter.outbound.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.thecatlong.back.adapter.outbound.persistence.converter.ProductoEntityToProducto;
import com.thecatlong.back.adapter.outbound.persistence.entity.ProductoEntity;
import com.thecatlong.back.adapter.outbound.persistence.repository.ProductoRepository;
import com.thecatlong.back.application.provider.out.ProductoService;
import com.thecatlong.back.domain.Producto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoAdapter implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoEntityToProducto converter;
    private final ConversionService conversionService;

    @Override
    public Producto findById(Long id) {
        Optional<ProductoEntity> productoEntity = productoRepository.findById(id);
        if(!productoEntity.isPresent())
            return null;
        return toDomain(productoEntity.get());
    }

    @Override
    public List<Producto> findByNombre(String nombre) {
        List<ProductoEntity> productoEntities = productoRepository.findByNombreContainingIgnoreCase(nombre);
        return toDomainList(productoEntities);
    }

    @Override
    public List<Producto> findAll() {
        List<ProductoEntity> productoEntities = productoRepository.findAll();
        return toDomainList(productoEntities);
    }

    @Override
    public Producto save(Producto producto) {
        ProductoEntity entity = conversionService.convert(producto, ProductoEntity.class);
        entity = productoRepository.save(entity);
        return toDomain(entity);
    }


    private List<Producto> toDomainList(List<ProductoEntity> productoEntities){
        List<Producto> productoList = new ArrayList<>();
        if(productoEntities.isEmpty()) 
            return productoList;
        productoEntities.forEach(d -> productoList.add(toDomain(d)));
        return productoList;
    }
    
    private Producto toDomain(ProductoEntity productoEntity) {
        return converter.convert(productoEntity);
    }

    

    
}
