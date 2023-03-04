package com.thecatlong.back.application.test;

import org.springframework.stereotype.Service;

import com.thecatlong.back.application.provider.in.TestSearchService;
import com.thecatlong.back.application.provider.out.TestService;
import com.thecatlong.back.domain.Test;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TestSearchUseCase implements TestSearchService{

    private final TestService testService;
    @Override
    public Test searchById(long id) {
        return testService.searchById(id);
    }

}
