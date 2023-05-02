package com.thecatlong.back.domain;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(Include.NON_NULL)
public class Carro {
    // id producto, cantidad
    private Map<Long,Long> productos;

    private boolean activo;

    
}
