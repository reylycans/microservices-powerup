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
@Table(name = "restaurant")
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id",scale = 0,precision = 12)
    private Long id;

    @Column(name = "name",length = 50,nullable = false)
    private String name;

    @Column(name = "nit",length = 15,nullable = false)
    private String nit;

    @Column(name = "address",length = 50,nullable = false)
    private String address;

    @Column(name = "phone",length = 13,nullable = false)
    private String phone;

    @Column(name = "urlLogo",length = 50,nullable = false)
    private String urlLogo;

    @Column(name = "ownerId",scale = 0,precision = 12,nullable = false)
    private Long  ownerId;
}
