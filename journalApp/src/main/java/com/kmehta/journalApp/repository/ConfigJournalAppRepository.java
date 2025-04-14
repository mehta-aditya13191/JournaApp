package com.kmehta.journalApp.repository;


import com.kmehta.journalApp.entity.ConfigJournalEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalEntity, ObjectId> {
}
