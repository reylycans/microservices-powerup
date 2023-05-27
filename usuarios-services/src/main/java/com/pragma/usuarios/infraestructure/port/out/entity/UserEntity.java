package com.pragma.usuarios.infraestructure.port.out.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",scale = 0,precision = 12)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "identityDocument",nullable = false)
    private Long identityDocument;

    @Column(name = "cellPhone",nullable = false)
    private String cellPhone;

    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    private RolEntity rol;
}
