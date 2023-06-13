package com.pragma.hexagonal.infraestructure.port.out.entity;

import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "order_detail",schema = "pragma")
@Data
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id",scale = 0,precision = 12)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id")
    private DishEntity dish;

    @Column(name = "amount")
    private Long amount;

}
