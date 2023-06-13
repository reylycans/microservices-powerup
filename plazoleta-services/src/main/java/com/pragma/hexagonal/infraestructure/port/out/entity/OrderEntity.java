package com.pragma.hexagonal.infraestructure.port.out.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="orders",schema = "pragma")
@Data
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",scale = 0,precision = 12,insertable = false)
    private Long id;

    @Column(name = "customer_id",scale = 0,precision = 12)
    private Long customerId;

    @Column(name = "create_at",length = 20,nullable = false)
    private LocalDate createAt;

    @Column(name = "state",length = 20,nullable = false)
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id",nullable = false)
    private RestaurantEntity restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chef_id")
    private RestaurantEmployeeEntity restaurantEmployee;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinTable(
            name = "orders_dish_detail",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "order_detail_id"))
    private Set<OrderDetailEntity> dishes;


}
