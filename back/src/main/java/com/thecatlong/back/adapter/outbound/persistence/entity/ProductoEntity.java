package com.thecatlong.back.adapter.outbound.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto", schema= "core")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoEntity {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String urlImagen;

    @Column
    private Double precio;

    @Column 
    private Double descuento;

    @Column
    private Double stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_deporte")
    private DeporteEntity deporteEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipologia_producto")
    private TipologiaProductoEntity tipologiaProductoEntity;
}
