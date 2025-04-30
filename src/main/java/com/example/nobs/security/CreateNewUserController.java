package com.example.nobs.security;


import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CreateNewUserController {

    private final PasswordEncoder encoder;

    private final Custom_UserRepo customUserRepo;

    public CreateNewUserController(PasswordEncoder encoder, Custom_UserRepo customUserRepo) {
        this.encoder = encoder;
        this.customUserRepo = customUserRepo;
    }

    @PostMapping("/createnewuser")
    public ResponseEntity<String> createnewUser (@RequestBody Custom_User user){
        Optional<Custom_User> optionalCustomUser = customUserRepo.findById(user.getUsername());
        if(!optionalCustomUser.isPresent()){
            customUserRepo.save(new Custom_User(user.getUsername(), encoder.encode(user.getPassword())));
            return ResponseEntity.ok("SUCCESS");
        }else return ResponseEntity.badRequest().body("FAILURE");
    }
}
