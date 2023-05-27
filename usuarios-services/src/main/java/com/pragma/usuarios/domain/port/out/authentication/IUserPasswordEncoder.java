package com.pragma.usuarios.domain.port.out.authentication;

public interface IUserPasswordEncoder {
    String encode(String passwrod);
}
