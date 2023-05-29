package com.pragma.hexagonal.domain.exception;

public class CategoryDomainException extends RuntimeException{

    public CategoryDomainException(String message){
        super(message);
    }
}
