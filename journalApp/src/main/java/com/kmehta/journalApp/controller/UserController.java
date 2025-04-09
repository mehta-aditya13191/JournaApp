package com.kmehta.journalApp.controller;

import com.kmehta.journalApp.entity.UserEntity;
import com.kmehta.journalApp.repository.UserEntityRepository;
import com.kmehta.journalApp.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    public UserEntityRepository userEntityRepository;


//    @GetMapping
//    public ResponseEntity<?> getAll(){
//        List<UserEntity> all = userEntityService.getAll();
//
//        if(all !=null && !all.isEmpty()){
//            return new ResponseEntity<>(all, HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }



    @PutMapping
    public ResponseEntity<?> updateUserById(@RequestBody UserEntity newUser){

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            UserEntity userInDb = userEntityService.findByUsername(username);
            userInDb.setUserName(newUser.getUserName());
            userInDb.setPassword(newUser.getPassword());
            userEntityService.saveNewUser(userInDb);
            return new ResponseEntity<>(userInDb,HttpStatus.OK);


//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    @DeleteMapping
    public ResponseEntity<?> deleteUserById(@RequestBody UserEntity newUser){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         userEntityRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>("User deleted",HttpStatus.OK);


//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
