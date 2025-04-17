package br.com.dio.Model;


import lombok.Data;

@Data
public class Courses extends Content {
    private String title;
    private String description;
    private int numberHours;

    public Courses(String title, String description, int numberHours) {
        this.title = title;
        this.description = description;
        this.numberHours = numberHours;
    }

    @Override
    public double calcXP() {
        return DEFAULT_XP + 5.0;
    }


}
