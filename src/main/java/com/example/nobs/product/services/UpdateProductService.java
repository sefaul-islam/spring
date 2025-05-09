package com.example.nobs.product.services;

import com.example.nobs.exception.ProductNotFoundException;
import com.example.nobs.product.Command;
import com.example.nobs.product.ProductRepository;
import com.example.nobs.product.model.Product;
import com.example.nobs.product.model.ProductDTO;
import com.example.nobs.product.model.UpdateProductCommand;
import com.example.nobs.product.validators.ProductValidator;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {

    private ProductRepository productrepository;

    public UpdateProductService(ProductRepository productrepository) {
        this.productrepository = productrepository;
    }

    @Override
    @CacheEvict(value = "productCache", key ="command.getId()" )
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product>productOptional = productrepository.findById(command.getId());
        if(productOptional.isPresent()){
            Product product= command.getProduct();
            product.setId(command.getId());
//            ProductValidator.validateExecute(product);
            productrepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }
        throw new ProductNotFoundException();
    }
}
