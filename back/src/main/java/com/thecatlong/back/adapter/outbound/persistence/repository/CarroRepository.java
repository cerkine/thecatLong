package com.thecatlong.back.adapter.outbound.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thecatlong.back.adapter.outbound.persistence.entity.CarroEntity;

public interface CarroRepository extends JpaRepository<CarroEntity,Long>{

    Optional<CarroEntity> findByUsuario_IdAndActivo(Long usuarioId, boolean activo);
}
