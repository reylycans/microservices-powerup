package com.pragma.usuarios.infraestructure.config;

import com.pragma.usuarios.domain.port.in.IRolServicePort;
import com.pragma.usuarios.domain.port.in.IUserServicePort;
import com.pragma.usuarios.domain.port.out.IRolRepository;
import com.pragma.usuarios.domain.port.out.authentication.IToken;
import com.pragma.usuarios.domain.port.out.IUserRepository;
import com.pragma.usuarios.domain.port.out.authentication.IUserPasswordEncoder;
import com.pragma.usuarios.domain.port.out.feignclients.IRestaurantEmployeeFeignClientRepository;
import com.pragma.usuarios.domain.port.out.feignclients.IRestaurantFeignClientRepository;
import com.pragma.usuarios.domain.usercase.RolServicePort;
import com.pragma.usuarios.domain.usercase.UserServicePort;
import com.pragma.usuarios.infraestructure.port.out.adapter.RolRepository;
import com.pragma.usuarios.infraestructure.port.out.adapter.UserRepository;
import com.pragma.usuarios.infraestructure.port.out.authenticationadapter.Token;
import com.pragma.usuarios.infraestructure.port.out.authenticationadapter.UserPasswordEncoder;
import com.pragma.usuarios.infraestructure.port.out.feignclients.IRestaurantEmployeeFeignClient;
import com.pragma.usuarios.infraestructure.port.out.feignclients.IRestaurantFeignClient;
import com.pragma.usuarios.infraestructure.port.out.feignclients.adapter.RestaurantEmployeeFeignClientRepository;
import com.pragma.usuarios.infraestructure.port.out.feignclients.adapter.RestaurantFeignClientRepository;
import com.pragma.usuarios.infraestructure.port.out.feignclients.mapper.IRestaurantEmployeeFeignMapper;
import com.pragma.usuarios.infraestructure.port.out.feignclients.mapper.IRestaurantFeignMapper;
import com.pragma.usuarios.infraestructure.port.out.mapper.IRolEntityMapper;
import com.pragma.usuarios.infraestructure.port.out.mapper.IUserEntityMapper;
import com.pragma.usuarios.infraestructure.port.out.repository.IRolJpaRepository;
import com.pragma.usuarios.infraestructure.port.out.repository.IUserJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public IUserServicePort userServicePort(IUserRepository userRepository, IToken token,
                                            IUserPasswordEncoder userPasswordEncoder,
                                            IRolRepository rolRepository,
                                            IRestaurantFeignClientRepository restaurantFeignClientRepository,
                                            IRestaurantEmployeeFeignClientRepository restaurantEmployeeFeignClientRepository){
        return new UserServicePort(userRepository,token,userPasswordEncoder,
                      rolRepository,restaurantFeignClientRepository,restaurantEmployeeFeignClientRepository);
    }
    @Bean
    public IUserRepository userRepository(IUserJpaRepository userJpaRepository, IUserEntityMapper userEntityMapper){
        return new UserRepository(userJpaRepository,userEntityMapper);
    }
    @Bean
    public IRolServicePort rolServicePort(IRolRepository rolRepository){
        return new RolServicePort(rolRepository);
    }
    @Bean
    public IRolRepository rolRepository(IRolJpaRepository rolJpaRepository, IRolEntityMapper rolEntityMapper){
        return new RolRepository(rolJpaRepository,rolEntityMapper);
    }
    @Bean
    public IToken token(){
        return new Token();
    }
    @Bean
    public IUserPasswordEncoder userPasswordEncoder(){
        return new UserPasswordEncoder();
    }

    @Bean
    public IRestaurantFeignClientRepository restaurantFeignClientRepository(IRestaurantFeignClient restaurantFeignClient,
                                                                            IRestaurantFeignMapper restaurantFeignMapper){
        return new RestaurantFeignClientRepository(restaurantFeignClient,restaurantFeignMapper);
    }
    @Bean
    public IRestaurantEmployeeFeignClientRepository restaurantEmployeeFeignClientRepository(IRestaurantEmployeeFeignClient restaurantEmployeeFeignClient,
                                                                                            IRestaurantEmployeeFeignMapper restaurantEmployeeFeignMapper){
        return new RestaurantEmployeeFeignClientRepository(restaurantEmployeeFeignClient,restaurantEmployeeFeignMapper);
    }
}
