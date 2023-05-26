package com.pragma.usuarios.infraestructure.security;

import com.pragma.usuarios.domain.model.UserModel;
import com.pragma.usuarios.infraestructure.port.out.entity.UserEntity;
import com.pragma.usuarios.infraestructure.port.out.mapper.IUserEntityMapper;
import com.pragma.usuarios.infraestructure.port.out.repository.IUserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private final IUserJpaRepository userJpaRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity usuarioEntity = userJpaRepository.findOneByEmail(email).orElseThrow(()->new UsernameNotFoundException("El usuario con email "+email+" no existe."));
        UserModel userModel= userEntityMapper.toUserModel(usuarioEntity);

        return new UserDetailsImpl(userModel);
    }
}
