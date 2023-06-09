package com.pragma.hexagonal.domain.exception;

public class CategoryDomainException extends RuntimeException{

    private String code;
    public CategoryDomainException(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
