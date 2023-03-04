package com.thecatlong.back.adapter.outbound.persistence;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.thecatlong.back.adapter.outbound.persistence.entity.TestEntity;
import com.thecatlong.back.adapter.outbound.persistence.repository.TestRepository;
import com.thecatlong.back.application.provider.out.TestService;
import com.thecatlong.back.domain.Test;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TestAdapter implements TestService {

    private final TestRepository testRepository;
    @Override
    public Test searchById(long id) {
        Optional<TestEntity> optionalEntity = testRepository.findById(id);
        if(!optionalEntity.isPresent()){
            return null;
        }

        return toDomain(optionalEntity.get());
    }
    private Test toDomain(TestEntity entity) {
        return Test.builder().id(entity.getId()).nombre(entity.getNombre()).build();
    }
    
}
