package br.com.dio.model;

import lombok.*;

import java.time.LocalDate;

//@data é um resumo de tudo isso:
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString

public class UserModel {
    private int code;
    private String username;
    private LocalDate birthdate;
}
