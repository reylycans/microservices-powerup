package com.pragma.usuarios.infraestructure.port.out.authenticationadapter;

import com.pragma.usuarios.domain.port.out.authentication.IToken;
import com.pragma.usuarios.infraestructure.security.TokenUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Token implements IToken {

    @Override
    public String getBearerToken() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
    }

    @Override
    public String getUserAuthenticationRol(String token) {
        return TokenUtils.getUsuarioAutenticadoRol(token.replace("Bearer",""));
    }

    @Override
    public Long getUserAuthenticationId(String token) {
        return TokenUtils.getUsuarioAutenticadoId(token.replace("Bearer",""));
    }
}
