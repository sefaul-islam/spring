package com.example.nobs.product.validators;

import com.example.nobs.exception.ErrorMessages;
import com.example.nobs.exception.ProductNotValidException;
import com.example.nobs.product.model.Product;
import io.micrometer.common.util.StringUtils;

public class ProductValidator {
    private ProductValidator(){

    }
    public static void validateExecute(Product product) {
        if(StringUtils.isEmpty(product.getName())){
            throw new ProductNotValidException(ErrorMessages.NAME_REQUIRED.getMessage());
        }
        if(product.getDescription().length() < 20){
            throw new ProductNotValidException(ErrorMessages.DESCRIPTION_LENGTH.getMessage());
        }

        if(product.getPrice() == null || product.getPrice()<0.00){
            throw new ProductNotValidException(ErrorMessages.PRICE_CANNOT_BE_INVALIDE.getMessage());
        }
    }
}
