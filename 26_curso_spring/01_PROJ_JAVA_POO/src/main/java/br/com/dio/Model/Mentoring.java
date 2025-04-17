package br.com.dio.Model;

import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
public class Mentoring extends Content {
    private String title;
    private String description;
    private LocalDate dateMentoring = LocalDate.now();

    public Mentoring(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public double calcXP() {
        return DEFAULT_XP + 20.0;
    }


}
