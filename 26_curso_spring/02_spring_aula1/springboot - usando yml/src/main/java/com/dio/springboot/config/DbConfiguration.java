package com.dio.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DbConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;



    @Profile("dev")
    @Bean
    public String testDatabaseConnection() {
        System.out.println("DB connection for H2 - DEV");
        System.out.println("Driver Class: " + driverClassName);
        System.out.println("Url: " + url);
        return "DB Connection to H2_TEST";
    }


    @Profile("prod")
    @Bean
    public String prodDatabaseConnection() {
        System.out.println("DB connection for PRODUCTION MYSQL");
        System.out.println("Driver Class: " + driverClassName);
        System.out.println("Url: " + url);
        return "DB Connection to PRODUCTION MYSQL";
    }
}
