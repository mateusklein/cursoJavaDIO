package br.com.dio.model;


import br.com.dio.annotation.FieldFormatEnum;
import br.com.dio.annotation.SerializerMethod;
import br.com.dio.annotation.SerializerType;

import java.time.LocalDateTime;

@SerializerType(fieldFormat = FieldFormatEnum.PASCAL_CASE, prettify = false)
public class Person {
    private Long id;
    private String name;
    private int age;

    public Person() {
    }

    public Person(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @SerializerMethod("firstPersonName")
    public String firstName(){
        return name.split(" ")[0];
    }
}

