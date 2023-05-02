package com.thecatlong.back.adapter.outbound.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thecatlong.back.adapter.outbound.persistence.entity.CompositeKeyProductoCarro;
import com.thecatlong.back.adapter.outbound.persistence.entity.ProductoCarritoEntity;

public interface ProductoCarritoRepository extends JpaRepository<ProductoCarritoEntity, CompositeKeyProductoCarro>{
    
    List<ProductoCarritoEntity> findByCarroId(Long carroId);
}
