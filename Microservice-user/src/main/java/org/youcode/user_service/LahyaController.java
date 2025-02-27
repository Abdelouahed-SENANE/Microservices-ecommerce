package org.youcode.user_service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LahyaController {

    @GetMapping("/la7ya")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("ANA ABDELOUAHED LA7YA" , HttpStatus.OK);
    }
}
