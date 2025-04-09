package com.kmehta.journalApp.controller;

import com.kmehta.journalApp.entity.UserEntity;
import com.kmehta.journalApp.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserEntityService userEntityService;



    @PostMapping("/create-user")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        try{
            userEntityService.saveNewUser(userEntity);
            return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";
    }
}
