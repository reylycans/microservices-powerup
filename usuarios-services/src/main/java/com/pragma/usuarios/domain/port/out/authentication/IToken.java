package com.pragma.usuarios.domain.port.out.authentication;

public interface IToken {
    String getBearerToken();
    String getUserAuthenticationRol(String token);
    Long getUserAuthenticationId(String token);
}
