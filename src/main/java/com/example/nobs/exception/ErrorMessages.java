package com.example.nobs.exception;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product Not Found.");
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
