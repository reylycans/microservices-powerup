package com.pragma.hexagonal.infraestructure.port.out.adapter;

import com.pragma.hexagonal.domain.port.out.IToken;
import com.pragma.hexagonal.infraestructure.security.TokenUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Token implements IToken {

    @Override
    public String getBearerToken() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
    }

    @Override
    public Long getUserAuthenticateId(String token) {
        return TokenUtils.getUsuarioAutenticadoId(token.replace("Bearer ",""));
    }
}
