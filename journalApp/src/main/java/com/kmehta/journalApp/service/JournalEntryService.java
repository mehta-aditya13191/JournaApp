package com.kmehta.journalApp.service;

import com.kmehta.journalApp.entity.JournalEntry;
import com.kmehta.journalApp.entity.UserEntity;
import com.kmehta.journalApp.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JournalEntryService {

    @Autowired
    public JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserEntityService userEntityService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){

        try {
            UserEntity user = userEntityService.findByUsername(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userEntityService.saveUser(user);
        }
        catch (Exception e){
            System.out.println(e);
            throw  new RuntimeException("An error occur while saving an entry ",e);
        }


    }

    public void saveEntry(JournalEntry journalEntry){
            journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public Boolean deleteById(ObjectId id, String userName){
        boolean removed = false;
        try {
            UserEntity user = userEntityService.findByUsername(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if(removed){
                userEntityService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }

        }
        catch (Exception e){
            System.out.println(e);
            throw  new RuntimeException("An error occur while deleting an entry ",e);
        }

        return removed;
    }


}
