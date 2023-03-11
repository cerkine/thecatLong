package com.thecatlong.back.adapter.outbound.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deporte", schema = "core")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class DeporteEntity {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String codigo;
    @Column
    private String nombre;
    @Column
    private String descripcion;
}
