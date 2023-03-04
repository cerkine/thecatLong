package com.thecatlong.back.adapter.outbound.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thecatlong.back.adapter.outbound.persistence.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity,Long> {
    
}
