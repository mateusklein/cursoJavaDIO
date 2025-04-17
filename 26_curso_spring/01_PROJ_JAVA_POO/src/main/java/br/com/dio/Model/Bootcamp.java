package br.com.dio.Model;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Bootcamp {
    private String name;
    private String description;
    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate = startDate.plusDays(45);

    private List<Devs> devs = new ArrayList<>();
    private List<Content> contents = new ArrayList<>();

    public Bootcamp(String name, String description) {
        this.name = name;
        this.description = description;
    }



}
