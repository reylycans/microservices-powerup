package com.pragma.hexagonal.infraestructure.port.out.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "order_restaurant")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",scale = 0,precision = 12)
    private Long id;
    private Long customerId;

    @Column(name = "createAt",length = 20,nullable = false)
    private LocalDate createAt;

    @Column(name = "state",length = 20,nullable = false)
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id",nullable = false)
    private RestaurantEntity restaurant;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetailEntity> dish;
}
