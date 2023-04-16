package com.thecatlong.back.adapter.outbound.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thecatlong.back.adapter.outbound.persistence.entity.TipologiaProductoEntity;

public interface TipologiaProductoRepository extends JpaRepository<TipologiaProductoEntity, Long> {
    
}
