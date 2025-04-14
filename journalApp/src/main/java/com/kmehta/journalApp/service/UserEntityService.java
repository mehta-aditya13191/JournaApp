package com.kmehta.journalApp.service;

import com.kmehta.journalApp.entity.UserEntity;
import com.kmehta.journalApp.repository.UserEntityRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserEntityService {
    @Autowired
    public UserEntityRepository userEntityRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean saveNewUser(UserEntity userEntity){
        try {
            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            userEntity.setRoles(Arrays.asList("USER"));
            userEntityRepository.save(userEntity);
            return true;
        }
        catch (Exception e){
            log.error("Exception",e);
            return false;
        }
    }

    public boolean saveUser(UserEntity userEntity){
        try {
            userEntityRepository.save(userEntity);
            return true;
        }
        catch (Exception e){
            log.error("Exception",e);
            return false;
        }
    }

    public void saveAdmin(UserEntity userEntity){
        try {
            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            userEntity.setRoles(Arrays.asList("USER","ADMIN"));
            userEntityRepository.save(userEntity);
        }
        catch (Exception e){
            log.error("Exception",e);
        }
    }


    public List<UserEntity> getAll(){
        return userEntityRepository.findAll();
    }

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
