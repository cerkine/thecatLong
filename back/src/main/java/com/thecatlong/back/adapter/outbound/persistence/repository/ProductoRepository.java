package com.thecatlong.back.adapter.outbound.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thecatlong.back.adapter.outbound.persistence.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity,Long>{
    List<ProductoEntity> findByNombreContainingIgnoreCase(String nombre);
}
