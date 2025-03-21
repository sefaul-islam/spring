package com.example.nobs.product.services;

import com.example.nobs.product.ProductRepository;
import com.example.nobs.product.Query;
import com.example.nobs.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class SearchProductService implements Query<String, List<ProductDTO>> {
    private final ProductRepository productrepository;

    public SearchProductService(ProductRepository productrepository) {
        this.productrepository = productrepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(String name) {
        return ResponseEntity.ok(productrepository.findByNameOrDescriptionContaining(name).stream().map(ProductDTO::new).toList());
    }
}
