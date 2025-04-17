package br.com.dio.Model;

import lombok.Data;

@Data
public abstract class Content {
    private String title;
    private String description;
    protected double DEFAULT_XP = 10d;

    public abstract double calcXP();
}
