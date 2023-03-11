package com.thecatlong.back.adapter.outbound.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.thecatlong.back.adapter.outbound.persistence.entity.DeporteEntity;
import com.thecatlong.back.adapter.outbound.persistence.repository.DeporteRepository;
import com.thecatlong.back.application.provider.out.DeporteService;
import com.thecatlong.back.domain.Deporte;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeporteAdapter implements DeporteService{
    private final DeporteRepository deporteRepository;
    @Override
    public Deporte findById(Long id) {
        Optional<DeporteEntity> deporteEntity = deporteRepository.findById(id);
        if(!deporteEntity.isPresent())
            return null;
        return toDomain(deporteEntity.get());
    }
    
    @Override
    public List<Deporte> findByNombre(String nombre) {
        List<DeporteEntity> deporteEntities = deporteRepository.findByNombreContainingIgnoreCase(nombre);
        return toDomainList(deporteEntities);
    }
    
    @Override
    public List<Deporte> findAll() {
     List<DeporteEntity> deporteEntities = deporteRepository.findAll();
     return toDomainList(deporteEntities);
    }

    private List<Deporte> toDomainList(List<DeporteEntity> deporteEntities){
        List<Deporte> deporteList = new ArrayList<>();
        if(deporteEntities.isEmpty()) 
            return deporteList;
        deporteEntities.forEach(d -> deporteList.add(toDomain(d)));
        return deporteList;
    }
    
    private Deporte toDomain(DeporteEntity deporteEntity) {
        return Deporte.builder()
            .codigo(deporteEntity.getCodigo())
            .nombre(deporteEntity.getNombre())
            .descripcion(deporteEntity.getDescripcion())
            .id(deporteEntity.getId()).build();
    }

    
}
