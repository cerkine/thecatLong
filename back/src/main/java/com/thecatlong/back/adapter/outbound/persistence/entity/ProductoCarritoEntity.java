package com.thecatlong.back.adapter.outbound.persistence.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto_carro", schema= "core")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@IdClass(CompositeKeyProductoCarro.class)
public class ProductoCarritoEntity {

    @Id
    @Column(name = "id_carro", insertable = false, updatable = false)
    Long carroId;

    @Id
    @Column(name = "id_producto", insertable = false, updatable = false)
    Long productoId;


    @ManyToOne
    @JoinColumn(name = "id_carro", insertable = false, updatable = false)
    CarroEntity carro;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    ProductoEntity producto;

    @Column
    private Long cantidad;
}
