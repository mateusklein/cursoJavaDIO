package br.com.dio.model;
import lombok.Data;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Card {
    protected Long cardId;
    public String title;
    public String description;
    public OffsetDateTime createdAt;

    public Card(Long cardId, String title, String description, OffsetDateTime createdAt) {
        this.cardId = cardId;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }
}
