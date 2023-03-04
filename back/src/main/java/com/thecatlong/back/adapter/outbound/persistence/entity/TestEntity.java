package com.thecatlong.back.adapter.outbound.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "test", schema = "core")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity {
    @Id
    @Column
    private Long id;
    @Column
    private String nombre;
}
