package com.pragma.hexagonal.factory;

import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import com.pragma.hexagonal.domain.model.RestaurantModel;

import java.util.Optional;

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

    public static Optional<RestaurantEmployeeModel> getRestaurantEmployee(){
        RestaurantEmployeeModel restaurantEmployeeModel = new RestaurantEmployeeModel();
        restaurantEmployeeModel.setRestaurant(RestaurantFactoryDataTest.getRestaurant());
        restaurantEmployeeModel.setUserId(23L);

        return Optional.of(restaurantEmployeeModel);
    }
}
