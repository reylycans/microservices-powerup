package com.pragma.hexagonal.domain.port.out;

public interface IToken {
    String getBearerToken();
    Long getUserAuthenticateId(String token);
}
