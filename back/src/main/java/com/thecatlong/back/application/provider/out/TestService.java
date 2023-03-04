package com.thecatlong.back.application.provider.out;

import com.thecatlong.back.domain.Test;

public interface TestService {
    Test searchById(long id);
}
