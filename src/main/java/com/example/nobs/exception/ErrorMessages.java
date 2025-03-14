package com.example.nobs.exception;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product Not Found."),
    NAME_REQUIRED("Name is required"),
    DESCRIPTION_LENGTH("Description must be atleast 20 characters"),
    PRICE_CANNOT_BE_INVALIDE("Invalide Price");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
