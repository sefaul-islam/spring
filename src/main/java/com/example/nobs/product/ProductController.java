package com.example.nobs.product;

import com.example.nobs.exception.ProductNotFoundException;
import com.example.nobs.product.model.ErrorResponse;
import com.example.nobs.product.model.Product;
import com.example.nobs.product.model.ProductDTO;
import com.example.nobs.product.model.UpdateProductCommand;
import com.example.nobs.product.services.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    private final CreateProductService createproductservice;


    private final DeleteProductService deleteproductservice;


    private final GetProductService getproductservice;


    private final UpdateProductService updateproductservice;

    private final GetProductServiceById getproductservicebyid;

    private final SearchProductService searchproductservice;

    public ProductController(CreateProductService createproductservice, DeleteProductService deleteproductservice, GetProductService getproductservice, UpdateProductService updateproductservice, GetProductServiceById getproductservicebyid, SearchProductService searchproductservice) {
        this.createproductservice = createproductservice;
        this.deleteproductservice = deleteproductservice;
        this.getproductservice = getproductservice;
        this.updateproductservice = updateproductservice;
        this.getproductservicebyid = getproductservicebyid;
        this.searchproductservice = searchproductservice;
    }


    @PostMapping("/product")
    public ResponseEntity<ProductDTO> postController( @RequestBody Product product){
        return createproductservice.execute(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getController(){
        return getproductservice.execute(null);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getControllerById(@PathVariable Integer id){
        return getproductservicebyid.execute(id);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> putController(@PathVariable Integer id,@RequestBody Product product){
       return updateproductservice.execute(new UpdateProductCommand(id, product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteController(@PathVariable Integer id){
        return deleteproductservice.execute(id);
    }

    @GetMapping("/product/search")
    public ResponseEntity<List<ProductDTO>> searchProductByName(@RequestParam String name){
      return searchproductservice.execute(name);
    }

}
