package com.kmehta.journalApp.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Sentiment {
    HAPPY,
    SAD,
    ANGRY,
    ANXIOUS;

    @JsonCreator
    public static Sentiment fromString(String value) {
        return Sentiment.valueOf(value.toUpperCase());
    }
}
