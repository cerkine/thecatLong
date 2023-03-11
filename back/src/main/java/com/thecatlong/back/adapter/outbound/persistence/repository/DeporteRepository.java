package com.thecatlong.back.adapter.outbound.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thecatlong.back.adapter.outbound.persistence.entity.DeporteEntity;

public interface DeporteRepository extends JpaRepository<DeporteEntity,Long>{
    List<DeporteEntity> findByNombreContainingIgnoreCase(String nombre);
}
