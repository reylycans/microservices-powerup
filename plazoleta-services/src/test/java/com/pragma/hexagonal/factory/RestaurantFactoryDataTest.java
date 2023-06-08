package com.pragma.hexagonal.factory;

import com.pragma.hexagonal.domain.model.RestaurantModel;

public class RestaurantFactoryDataTest {

    public static RestaurantModel getRestaurant(){
        RestaurantModel restaurantModel = new RestaurantModel();
        restaurantModel.setId(1L);
        restaurantModel.setName("pragma");
        restaurantModel.setAddress("test");
        restaurantModel.setNit("123424");
        restaurantModel.setPhone("+57332332");
        restaurantModel.setUrlLogo("dytes");
        restaurantModel.setOwnerId(4L);

        return restaurantModel;
    }
}
