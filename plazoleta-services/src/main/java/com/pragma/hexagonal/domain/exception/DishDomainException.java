package com.pragma.hexagonal.domain.exception;


public class DishDomainException extends RuntimeException{
    private String code;
    public DishDomainException(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
