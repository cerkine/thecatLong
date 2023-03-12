package com.thecatlong.back.adapter.outbound.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipologia_producto", schema = "core")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TipologiaProductoEntity {
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
