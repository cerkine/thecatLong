package com.thecatlong.back.adapter.inbound.rest.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CarroActualResponse {

    private final List<ProductoResponse> productos;
    
}
