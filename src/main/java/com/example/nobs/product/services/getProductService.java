package com.example.nobs.product.services;

import com.example.nobs.product.Query;
import com.example.nobs.product.model.Product;
import com.example.nobs.product.productRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class getProductService implements Query<Void, List<Product>> {



    private final productRepository productrepository;

    public getProductService(productRepository productrepository) {
        this.productrepository = productrepository;
    }

    @Override
    public ResponseEntity<List<Product>> execute(Void input) {
        List<Product> products =productrepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
