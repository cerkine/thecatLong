package com.thecatlong.back.adapter.outbound.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.thecatlong.back.adapter.outbound.persistence.entity.TipologiaProductoEntity;
import com.thecatlong.back.adapter.outbound.persistence.repository.TipologiaProductoRepository;
import com.thecatlong.back.application.provider.out.TipologiaProductoService;
import com.thecatlong.back.domain.TipologiaProducto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipologiaProductoAdapter implements TipologiaProductoService {
    private final TipologiaProductoRepository tipologiaProductoRepository;
    private final ConversionService conversionService;

    @Override
    public List<TipologiaProducto> listarTodos() {
        List<TipologiaProductoEntity> entities = tipologiaProductoRepository.findAll();
        return converterListEntitiesToListDomain(entities);
    }

    public TipologiaProducto getById(Long id){
        Optional<TipologiaProductoEntity> optional = tipologiaProductoRepository.findById(id);
        if(optional.isPresent())
            return conversionService.convert(optional.get(), TipologiaProducto.class);
        return null;
    }

    private List<TipologiaProducto> converterListEntitiesToListDomain(List<TipologiaProductoEntity> entities) {
        List<TipologiaProducto> domains = new ArrayList<>();
        entities.forEach(entity -> domains.add(conversionService.convert(entity, TipologiaProducto.class)));
        return domains;
    }

}
