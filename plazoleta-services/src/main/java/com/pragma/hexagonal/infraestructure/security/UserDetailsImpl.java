package com.pragma.hexagonal.infraestructure.security;

import com.pragma.hexagonal.infraestructure.port.out.feignclients.dto.UserFeignDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final UserFeignDto userFeignDto;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userFeignDto.getRol().getName()));
    }

    @Override
    public String getPassword() {
        return userFeignDto.getPassword();
    }

    @Override
    public String getUsername() {
        return userFeignDto.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre(){
        return userFeignDto.getName();
    }

    public Long getId(){
        return userFeignDto.getId();
    }
}
