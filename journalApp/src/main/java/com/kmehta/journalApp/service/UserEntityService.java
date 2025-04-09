package com.kmehta.journalApp.service;

import com.kmehta.journalApp.entity.UserEntity;
import com.kmehta.journalApp.repository.UserEntityRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
@Component
public class UserEntityService {
    @Autowired
    public UserEntityRepository userEntityRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveNewUser(UserEntity userEntity){
        try {
            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            userEntity.setRoles(Arrays.asList("USER"));
            userEntityRepository.save(userEntity);
        }
        catch (Exception e){
            log.error("Exception",e);
        }
    }

    public void saveUser(UserEntity userEntity){
        try {
            userEntityRepository.save(userEntity);
        }
        catch (Exception e){
            log.error("Exception",e);
        }
    }

//    public List<UserEntity> getAll(){
//        return userEntityRepository.findAll();
//    }

    public Optional<UserEntity> findById(ObjectId id){
        return userEntityRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userEntityRepository.deleteById(id);
    }

    public UserEntity findByUsername(String username){
       return userEntityRepository.findByUserName(username);
    }
}
