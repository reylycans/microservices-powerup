package com.pragma.hexagonal.infraestructure.security;

import com.pragma.hexagonal.infraestructure.port.out.feignclients.IUserFeignClient;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.dto.UserFeignDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private  final IUserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserFeignDto userDto = userFeignClient.getUserByEmail(email);
        return new UserDetailsImpl(userDto);
    }
}
