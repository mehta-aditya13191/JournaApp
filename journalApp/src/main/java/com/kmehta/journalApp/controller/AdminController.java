package com.kmehta.journalApp.controller;

import com.kmehta.journalApp.cache.AppCache;
import com.kmehta.journalApp.entity.UserEntity;
import com.kmehta.journalApp.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private AppCache appCache;

    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers() {
        List<UserEntity> all = userEntityService.getAll();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }

        return new ResponseEntity<>("No Users found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create-admin-user")
    public void createAdmin(@RequestBody UserEntity user){
        userEntityService.saveAdmin(user);
    }

   @GetMapping("clear-app-cache")
   public void clearAppCache(){
        appCache.init();
    }
}
