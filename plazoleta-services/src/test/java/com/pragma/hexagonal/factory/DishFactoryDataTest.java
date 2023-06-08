package com.pragma.hexagonal.factory;

import com.pragma.hexagonal.domain.model.DishModel;

import java.math.BigDecimal;

public class DishFactoryDataTest {

    public static DishModel getDish(){
        DishModel dishModel = new DishModel();
        dishModel.setName("arroz valanciana");
        dishModel.setPrice(new BigDecimal(200));
        dishModel.setUrlImage("testing");
        dishModel.setAsset(true);
        dishModel.setRestaurant(RestaurantFactoryDataTest.getRestaurant());
        dishModel.setCategory(CategoryFactoryDataTest.getCategory());

        return dishModel;
    }
}
