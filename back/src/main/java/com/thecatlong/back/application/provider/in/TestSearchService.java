package com.thecatlong.back.application.provider.in;

import com.thecatlong.back.domain.Test;

public interface TestSearchService {
    Test searchById(long id);

    Test searchByNombre(String nombre);
}
