package com.pragma.hexagonal.domain.exception;

import lombok.Data;


public class OrderDomainException extends RuntimeException{
    private String code;
    public OrderDomainException(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
