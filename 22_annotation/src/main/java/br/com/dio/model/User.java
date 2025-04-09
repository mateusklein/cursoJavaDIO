package br.com.dio.model;

import br.com.dio.annotation.SerializerType;

@SerializerType
public record User(
        Long id,
        String fullName,
        int age,
        double salary
) {
}
