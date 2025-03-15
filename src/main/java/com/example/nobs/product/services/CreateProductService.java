package com.example.nobs.product.services;

import com.example.nobs.exception.ErrorMessages;
import com.example.nobs.exception.ProductNotValidException;
import com.example.nobs.product.Command;
import com.example.nobs.product.model.Product;
import com.example.nobs.product.model.ProductDTO;
import com.example.nobs.product.ProductRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {
     private final ProductRepository productrepository;

    public CreateProductService(ProductRepository productrepository) {
        this.productrepository = productrepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {

        validateProduct(product);


        Product savedproduct= productrepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedproduct));
    }

    private static void validateProduct(Product product) {
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
