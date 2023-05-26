package com.pragma.hexagonal.infraestructure.port.out.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id",scale = 0,precision = 12)
    private Long id;
    @Column(name = "name",length = 50,nullable = false)
    private String name;
    @Column(name = "description",length = 100,nullable = false)
    private String description;
}
