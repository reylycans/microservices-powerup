package com.pragma.hexagonal.infraestructure.config;

import com.pragma.hexagonal.domain.port.in.*;
import com.pragma.hexagonal.domain.port.out.*;
import com.pragma.hexagonal.domain.port.out.feignclients.IUserFeignClientRepository;
import com.pragma.hexagonal.domain.usecase.*;
import com.pragma.hexagonal.infraestructure.port.out.adapter.*;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.IUserFeignClient;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.adapter.UserFeignClientRepository;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.mapper.IUserFeignMapper;
import com.pragma.hexagonal.infraestructure.port.out.mapper.IRestaurantEntityMapper;
import com.pragma.hexagonal.infraestructure.port.out.repository.IUserJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ICategoryServicePort categoryServicePort(ICategoryRepository categoryRepository){
        return new CategoryServicePort(categoryRepository);
    }
    @Bean
    public ICategoryRepository categoryRepository(){
        return new CategoryRepository();
    }
    @Bean
    public IDishServicePort dishServicePort(IDishRepository dishRepository){
        return new DishServicePort(dishRepository);
    }
    @Bean
    public IDishRepository dishRepository(){
        return new DishRepository();
    }
    @Bean
    public IOrderServicePort orderServicePort(IOrderRepository orderRepository){
        return new OrderServicePort(orderRepository);
    }
    @Bean
    public IOrderRepository orderRepository(){
        return new OrderRepository();
    }
    @Bean
    public IRestaurantEmployeeServicePort restaurantEmployeeServicePort(IRestaurantEmployeeRepository restaurantEmployeeRepository){
        return new RestaurantEmployeeServicePort(restaurantEmployeeRepository);
    }
    @Bean
    public IRestaurantEmployeeRepository restaurantEmployeeRepository(){
        return new RestaurantEmployeeRepository();
    }
    @Bean
    public IRestaurantServicePort restaurantServicePort(IRestaurantRepository restaurantRepository,
                                                        IUserFeignClientRepository userFeignClientRepository){
        return new RestaurantServicePort(restaurantRepository,userFeignClientRepository);
    }
    @Bean
    public IRestaurantRepository restaurantRepository(IUserJpaRepository userJpaRepository,
                                                      IRestaurantEntityMapper restaurantEntityMapper){
        return new RestaurantRepository(userJpaRepository,restaurantEntityMapper);
    }
    @Bean
    public IUserFeignClientRepository userFeignClientRepository(IUserFeignClient userFeignClient,
                                                                IUserFeignMapper userFeignMapper){
        return new UserFeignClientRepository(userFeignClient,userFeignMapper);
    }
}
