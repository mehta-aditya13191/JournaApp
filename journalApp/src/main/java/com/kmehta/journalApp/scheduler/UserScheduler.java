package com.kmehta.journalApp.scheduler;

import com.kmehta.journalApp.cache.AppCache;
import com.kmehta.journalApp.entity.JournalEntry;
import com.kmehta.journalApp.entity.UserEntity;
import com.kmehta.journalApp.enums.Sentiment;
import com.kmehta.journalApp.repository.UserEntityRepositoryImpl;
import com.kmehta.journalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserEntityRepositoryImpl userEntityRepository;


    @Autowired
    private AppCache appCache;

    @Scheduled(cron = "0 0 8 * * SUN")
    public void fetchUserAndSendSaMail() {

        List<UserEntity> users = userEntityRepository.getUserEntityForSA();
        for (UserEntity user : users) {
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<Sentiment> sentiments = journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x -> x.getSentiment()).collect(Collectors.toList());
            Map<Sentiment, Integer> sentimentCounts = new HashMap<>();
            for (Sentiment sentiment : sentiments) {
                if (sentiment != null)
                    sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment, 0) + 1);
            }
            Sentiment mostFrequentSentiment = null;
            int maxCount = 0;
            for (Map.Entry<Sentiment, Integer> entry : sentimentCounts.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    mostFrequentSentiment = entry.getKey();
                }
            }
           if(mostFrequentSentiment!=null){
               emailService.sendEmail(user.getEmail(), "Sentiment for the last 7 days", mostFrequentSentiment.toString());
           }

        }
    }

    @Scheduled(cron = "0 0/10 * ? * *")
    public void clearAppCache(){
        appCache.init();

    }
}
