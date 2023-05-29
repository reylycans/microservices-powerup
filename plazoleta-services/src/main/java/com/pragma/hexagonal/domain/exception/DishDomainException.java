package com.pragma.hexagonal.domain.exception;

public class DishDomainException extends RuntimeException{

    public DishDomainException(String message){
        super(message);
    }
}
