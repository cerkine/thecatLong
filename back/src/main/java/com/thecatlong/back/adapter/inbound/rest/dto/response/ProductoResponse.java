package com.thecatlong.back.adapter.inbound.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(Include.NON_NULL)
public class ProductoResponse {

    private final String nombre;
    private final Double stock;
    private final String descripcion;
    private final String urlImagen;

    private final Double precio;
    private final Double descuento;
    private final Deporte deporte;

    @Builder
    @Getter
    public static class Deporte {

        private final String codigo;
        private final String nombre;
        private final String descripcion;
    }

}
