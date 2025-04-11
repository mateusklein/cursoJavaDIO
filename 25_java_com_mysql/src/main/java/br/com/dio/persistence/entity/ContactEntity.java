package br.com.dio.persistence.entity;


import lombok.Data;

@Data
public class ContactEntity {
    private Long id;
    private String description;
    private String type;

    private EmployeeEntity employee;

}
