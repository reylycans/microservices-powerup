package com.pragma.usuarios.infraestructure.port.out.authenticationadapter;

import com.pragma.usuarios.domain.port.out.authentication.IUserPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserPasswordEncoder implements IUserPasswordEncoder {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public String encode(String passwrod) {
        return passwordEncoder.encode(passwrod);
    }
}
