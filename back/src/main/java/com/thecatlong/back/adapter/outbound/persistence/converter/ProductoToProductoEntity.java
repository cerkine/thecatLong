package com.thecatlong.back.adapter.outbound.persistence.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.thecatlong.back.adapter.outbound.persistence.entity.DeporteEntity;
import com.thecatlong.back.adapter.outbound.persistence.entity.ProductoEntity;
import com.thecatlong.back.adapter.outbound.persistence.entity.TipologiaProductoEntity;
import com.thecatlong.back.domain.Producto;

@Component
public class ProductoToProductoEntity implements Converter<Producto, ProductoEntity>  {

    @Override
    @Nullable
    public ProductoEntity convert(Producto producto) {
        return ProductoEntity.builder()
            .deporteEntity(DeporteEntity.builder().id(producto.getDeporte().getId()).build())
            .tipologiaProductoEntity(TipologiaProductoEntity.builder().id(producto.getTipologiaProducto().getId()).build())
            .descripcion(producto.getDescripcion())
            .descuento(producto.getDescuento())
            .nombre(producto.getNombre())
            .precio(producto.getPrecio())
            .stock(producto.getStock())
            .urlImagen(producto.getUrlImagen())
            .build();
    }
    
}
