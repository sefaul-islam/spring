package com.example.nobs.product.headers;

import com.example.nobs.product.model.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {
    @GetMapping("/header")
    public String getRegionalResponse(@RequestHeader(required = false,defaultValue = "US") String region){

         if(region.equals("US")) return "Bald Eagle Freedom";

         if(region.equals("CAN")) return "Maple Syrup";

         return "Country Not supported";

    }

    @GetMapping(value = "/header/product",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Product> getProduct(){
        Product product = new Product();
        product.setId(1);
        product.setName("super duper");
        product.setDescription("the greatest technician that ever lived");

        return ResponseEntity.ok(product);
    }
}
