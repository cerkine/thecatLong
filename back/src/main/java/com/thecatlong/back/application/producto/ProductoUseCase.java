package com.thecatlong.back.application.producto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.thecatlong.back.application.ValidationUtils;
import com.thecatlong.back.application.provider.out.DeporteService;
import com.thecatlong.back.application.provider.out.ProductoService;
import com.thecatlong.back.application.provider.out.TipologiaProductoService;
import com.thecatlong.back.domain.Deporte;
import com.thecatlong.back.domain.Producto;
import com.thecatlong.back.domain.TipologiaProducto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductoUseCase {
    private final ProductoService productoService;
    private final TipologiaProductoService tipologiaProductoService;
    private final DeporteService deporteService;
    public List<Producto> searchByNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty())
            return productoService.findByNombre(nombre);
        return productoService.findAll();
    }

    public Producto searchById(Long id) {
        return productoService.findById(id);
    }

    public Producto alta(Producto producto) {
        Deporte deporte = deporteService.findById(producto.getDeporte().getId());
        ValidationUtils.validateNotNull(deporte, "La id del deporte no es correcta");
        TipologiaProducto tipologiaProducto = tipologiaProductoService.getById(producto.getTipologiaProducto().getId());
        ValidationUtils.validateNotNull(tipologiaProducto, "La id de la tipologia de producto no es correcta");
        return productoService.alta(producto);
    }
}
