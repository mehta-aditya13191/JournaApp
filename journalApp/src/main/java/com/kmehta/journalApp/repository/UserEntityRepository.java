package com.kmehta.journalApp.repository;

import com.kmehta.journalApp.entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntityRepository extends MongoRepository<UserEntity, ObjectId> {
    UserEntity findByUserName(String userName);

    void deleteByUserName(String userName);
}
