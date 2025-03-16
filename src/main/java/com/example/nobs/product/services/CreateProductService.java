package com.example.nobs.product.services;

import com.example.nobs.exception.ErrorMessages;
import com.example.nobs.exception.ProductNotValidException;
import com.example.nobs.product.Command;
import com.example.nobs.product.model.Product;
import com.example.nobs.product.model.ProductDTO;
import com.example.nobs.product.ProductRepository;
import com.example.nobs.product.validators.ProductValidator;
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

        ProductValidator.validateExecute(product);
        Product savedproduct= productrepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedproduct));
    }



}
