package com.pragma.hexagonal.domain;

import com.pragma.hexagonal.domain.exception.RestaurantDomainException;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.domain.model.UserModel;
import com.pragma.hexagonal.domain.port.out.IRestaurantRepository;
import com.pragma.hexagonal.domain.port.out.feignclients.IUserFeignClientRepository;
import com.pragma.hexagonal.domain.service.RestaurantServicePort;
import com.pragma.hexagonal.factory.RestaurantFactoryDataTest;
import com.pragma.hexagonal.factory.UserFactoryDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class RestaurantServiceTest {
    @InjectMocks
    RestaurantServicePort restaurantServicePort;

    @Mock
    IRestaurantRepository restaurantRepository;

    @Mock
    IUserFeignClientRepository userFeignClientRepository;

    @Test
    public void saveRestaurant(){
        RestaurantModel restaurantModel = RestaurantFactoryDataTest.getRestaurant();
        UserModel userModel = UserFactoryDataTest.getUserOwner();

        Mockito.when(userFeignClientRepository.getUserById(restaurantModel.getOwnerId())).thenReturn(userModel);
        restaurantServicePort.save(restaurantModel);
        Mockito.verify(restaurantRepository).save(restaurantModel);
    }

    @Test
    public void saveRestaurantOwnerNotExist(){
        RestaurantModel restaurantModel = RestaurantFactoryDataTest.getRestaurant();
        UserModel userModel = UserFactoryDataTest.getUserOwner();

        Mockito.when(userFeignClientRepository.getUserById(7L)).thenReturn(userModel);
        assertThrows(RestaurantDomainException.class,
                ()->restaurantServicePort.save(restaurantModel));

    }

    @Test
    public void getRestaurantByOwner(){
        RestaurantModel restaurantModel = RestaurantFactoryDataTest.getRestaurant();
        Mockito.when(restaurantRepository.getRestaurantByOwner(restaurantModel.getOwnerId())).thenReturn(Optional.of(restaurantModel));

        restaurantServicePort.getRestaurantByOwner(restaurantModel.getOwnerId());
        Mockito.verify(restaurantRepository).getRestaurantByOwner(restaurantModel.getOwnerId());
    }

    @Test
    public void restaurantNonExistByOwner(){
        RestaurantModel restaurantModel = RestaurantFactoryDataTest.getRestaurant();
        Mockito.when(restaurantRepository.getRestaurantByOwner(restaurantModel.getOwnerId())).thenReturn(Optional.empty());

         assertThrows(RestaurantDomainException.class,
                ()-> restaurantServicePort.getRestaurantByOwner(7L));

    }

    @Test
    public void RestaurantsNotFoundWithPagination(){
        Mockito.when(restaurantRepository.getAllRestaurantsWithPagination(1,1)).thenReturn(Optional.empty());

        assertThrows(RestaurantDomainException.class,
                ()-> restaurantServicePort.getAllRestaurantsWithPagination(1,1));

    }


}
