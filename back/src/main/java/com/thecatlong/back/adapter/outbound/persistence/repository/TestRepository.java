package com.thecatlong.back.adapter.outbound.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.thecatlong.back.adapter.outbound.persistence.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity,Long> {

    Optional<TestEntity> findByNombre(String nombre);
}
