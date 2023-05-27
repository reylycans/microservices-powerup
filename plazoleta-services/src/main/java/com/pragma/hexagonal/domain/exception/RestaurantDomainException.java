package com.pragma.hexagonal.domain.exception;

public class RestaurantDomainException extends RuntimeException{

    public RestaurantDomainException(String message){
        super(message);
    }
}
