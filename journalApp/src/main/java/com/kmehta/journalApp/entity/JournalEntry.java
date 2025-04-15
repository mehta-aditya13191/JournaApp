package com.kmehta.journalApp.entity;

import com.kmehta.journalApp.enums.Sentiment;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


//@Document
@Document(collection ="journal_entries")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@NoArgsConstructor
public class JournalEntry {

    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;
    private Sentiment sentiment;



}
