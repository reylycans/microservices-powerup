package com.pragma.hexagonal.domain.exception;


public class RestaurantDomainException extends RuntimeException{
    private String code;
    public RestaurantDomainException(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
