package com.example.nobs.product.services;

import com.example.nobs.product.Command;
import com.example.nobs.product.model.Product;
import com.example.nobs.product.model.ProductDTO;
import com.example.nobs.product.ProductRepository;
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
       Product savedproduct= productrepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedproduct));
    }

}
