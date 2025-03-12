package com.example.nobs.product.services;

import com.example.nobs.exception.ProductNotFoundException;
import com.example.nobs.product.ProductRepository;
import com.example.nobs.product.Query;
import com.example.nobs.product.model.Product;
import com.example.nobs.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductServiceById implements Query<Integer, ProductDTO> {

    private final ProductRepository productrepository;

    public GetProductServiceById(ProductRepository productrepository) {
        this.productrepository = productrepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        Optional<Product> productOptional= productrepository.findById(input);
        if(productOptional.isPresent()){
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }
        throw new ProductNotFoundException();
    }
}
