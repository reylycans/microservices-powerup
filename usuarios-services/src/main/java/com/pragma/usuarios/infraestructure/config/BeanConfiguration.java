package com.pragma.usuarios.infraestructure.config;

import com.pragma.usuarios.domain.port.in.IRolServicePort;
import com.pragma.usuarios.domain.port.in.IUserServicePort;
import com.pragma.usuarios.domain.port.out.IRolRepository;
import com.pragma.usuarios.domain.port.out.IUserRepository;
import com.pragma.usuarios.domain.usercase.RolServicePort;
import com.pragma.usuarios.domain.usercase.UserServicePort;
import com.pragma.usuarios.infraestructure.port.out.adapter.RolRepository;
import com.pragma.usuarios.infraestructure.port.out.adapter.UserRepository;
import com.pragma.usuarios.infraestructure.port.out.mapper.IRolEntityMapper;
import com.pragma.usuarios.infraestructure.port.out.mapper.IUserEntityMapper;
import com.pragma.usuarios.infraestructure.port.out.repository.IRolJpaRepository;
import com.pragma.usuarios.infraestructure.port.out.repository.IUserJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public IUserServicePort userServicePort(IUserRepository userRepository){
        return new UserServicePort(userRepository);
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
}
