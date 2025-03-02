package com.example.nobs.product;

import com.example.nobs.product.model.Product;
import com.example.nobs.product.services.createProductService;
import com.example.nobs.product.services.deleteProductService;
import com.example.nobs.product.services.getProductService;
import com.example.nobs.product.services.updateProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {


    private final createProductService createproductservice;


    private final deleteProductService deleteproductservice;


    private final getProductService getproductservice;


    private final updateProductService updateproductservice;

    public productController(deleteProductService deleteproductservice, createProductService createproductservice, getProductService getproductservice, updateProductService updateproductservice) {
        this.deleteproductservice = deleteproductservice;
        this.createproductservice = createproductservice;
        this.getproductservice = getproductservice;
        this.updateproductservice = updateproductservice;
    }



    @PostMapping
    public ResponseEntity<String> postController(){
        return createproductservice.execute(null);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getController(){
        return getproductservice.execute(null);
    }
    @PutMapping
    public ResponseEntity<String> putController(){
       return updateproductservice.execute(null);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteController(){
        return deleteproductservice.execute(null);
    }
}
