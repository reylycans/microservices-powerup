package com.pragma.usuarios.infraestructure.port.out.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "rol")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id",scale = 0,precision = 12)
    private Long id;
    private String name;
    private String description;
}
