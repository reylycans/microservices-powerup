package com.pragma.hexagonal.infraestructure.port.out.entity;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "dish")
public class DishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id",scale = 0,precision = 12)
    private Long id;

    @Column(name = "name",length = 20)
    private String name;

    @Column(name = "price",scale = 2, precision = 17)
    private BigDecimal price;

    @Column(name = "description",length = 20)
    private String description;

    @Column(name = "urlImage",length = 50)
    private String urlImage;

    @Column(name = "asset",length = 50)
    private Boolean asset;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
