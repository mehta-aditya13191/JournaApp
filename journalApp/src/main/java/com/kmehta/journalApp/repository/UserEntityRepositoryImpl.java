package com.kmehta.journalApp.repository;

import com.kmehta.journalApp.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserEntityRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<UserEntity> getUserEntityForSA(){
        Query query = new Query();
        query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$"));
        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));

        List<UserEntity> userEntities = mongoTemplate.find(query, UserEntity.class);
        return userEntities;
    };


}
