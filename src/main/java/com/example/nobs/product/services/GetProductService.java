package com.example.nobs.product.services;

import com.example.nobs.exception.ProductNotFoundException;
import com.example.nobs.product.Query;
import com.example.nobs.product.model.Product;
import com.example.nobs.product.ProductRepository;
import com.example.nobs.product.model.ProductDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductService implements Query<Void, List<ProductDTO>> {



    private final ProductRepository productrepository;

    public GetProductService(ProductRepository productrepository) {
        this.productrepository = productrepository;
    }

    @Override
    @Cacheable("productCache")
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        List<Product> products =productrepository.findAll();
        List<ProductDTO> productDTOS=products.stream().map(ProductDTO::new).toList();


        return ResponseEntity.status(HttpStatus.OK).body(productDTOS);
    }
}
