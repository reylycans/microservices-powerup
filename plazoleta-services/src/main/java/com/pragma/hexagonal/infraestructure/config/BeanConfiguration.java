package com.pragma.hexagonal.infraestructure.config;

import com.pragma.hexagonal.domain.port.in.*;
import com.pragma.hexagonal.domain.port.out.*;
import com.pragma.hexagonal.domain.port.out.feignclients.IUserFeignClientRepository;
import com.pragma.hexagonal.domain.service.*;
import com.pragma.hexagonal.infraestructure.port.out.adapter.*;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.IUserFeignClient;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.adapter.UserFeignClientRepository;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.mapper.IUserFeignMapper;
import com.pragma.hexagonal.infraestructure.port.out.mapper.*;
import com.pragma.hexagonal.infraestructure.port.out.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ICategoryServicePort categoryServicePort(ICategoryRepository categoryRepository){
        return new CategoryServicePort(categoryRepository);
    }
    @Bean
    public ICategoryRepository categoryRepository(ICategoryJpaRepository categoryJpaRepository,
                                                  ICategoryEntityMapper categoryEntityMapper){
        return new CategoryRepository(categoryJpaRepository,categoryEntityMapper);
    }
    @Bean
    public IDishServicePort dishServicePort(IDishRepository dishRepository){
        return new DishServicePort(dishRepository);
    }
    @Bean
    public IDishRepository dishRepository(IDishJpaRepository dishJpaRepository,
                                          IDishEntityMapper dishEntityMapper){
        return new DishRepository(dishJpaRepository,dishEntityMapper);
    }
    @Bean
    public IOrderServicePort orderServicePort(IOrderRepository orderRepository,IToken token,IRestaurantEmployeeRepository restaurantEmployeeRepository){
        return new OrderServicePort(orderRepository,token,restaurantEmployeeRepository);
    }
    @Bean
    public IOrderRepository orderRepository(IOrderJpaRepository orderJpaRepository,
                                            IOrderEntityMapper orderEntityMapper){
        return new OrderRepository(orderJpaRepository,orderEntityMapper);
    }
    @Bean
    public IRestaurantEmployeeServicePort restaurantEmployeeServicePort(IRestaurantEmployeeRepository restaurantEmployeeRepository){
        return new RestaurantEmployeeServicePort(restaurantEmployeeRepository);
    }
    @Bean
    public IRestaurantEmployeeRepository restaurantEmployeeRepository(IRestaurantEmployeeJpaRepository restaurantEmployeeJpaRepository,
                                                                      IRestaurantEmployeeEntityMapper restaurantEmployeeEntityMapper){
        return new RestaurantEmployeeRepository(restaurantEmployeeJpaRepository,restaurantEmployeeEntityMapper);
    }
    @Bean
    public IRestaurantServicePort restaurantServicePort(IRestaurantRepository restaurantRepository,
                                                        IUserFeignClientRepository userFeignClientRepository){
        return new RestaurantServicePort(restaurantRepository,userFeignClientRepository);
    }
    @Bean
    public IRestaurantRepository restaurantRepository(IRestaurantJpaRepository userJpaRepository,
                                                      IRestaurantEntityMapper restaurantEntityMapper){
        return new RestaurantRepository(userJpaRepository,restaurantEntityMapper);
    }
    @Bean
    public IUserFeignClientRepository userFeignClientRepository(IUserFeignClient userFeignClient,
                                                                IUserFeignMapper userFeignMapper){
        return new UserFeignClientRepository(userFeignClient,userFeignMapper);
    }
    @Bean
    public IToken token(){
        return new Token();
    }
}
