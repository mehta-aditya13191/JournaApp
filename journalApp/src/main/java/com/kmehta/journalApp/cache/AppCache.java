package com.kmehta.journalApp.cache;

import com.kmehta.journalApp.entity.ConfigJournalEntity;
import com.kmehta.journalApp.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum keys{
        WEATHER_API
    }

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

  public   Map<String,String> APP_CACHE;

    @PostConstruct
    public void  init(){
        APP_CACHE= new HashMap<>();
        List<ConfigJournalEntity> all = configJournalAppRepository.findAll();

        all.forEach((entry)->{
            APP_CACHE.put(entry.getKey(),entry.getValue());

        });
    }
}
