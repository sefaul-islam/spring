package com.example.nobs.product.services;

import com.example.nobs.product.Command;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class updateProductService implements Command<Void,String> {

    @Override
    public ResponseEntity<String> execute(Void input) {
        return ResponseEntity.status(HttpStatus.OK).body( "Post updated") ;
    }
}
