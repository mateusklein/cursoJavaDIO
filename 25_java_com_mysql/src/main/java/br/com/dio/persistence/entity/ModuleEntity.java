package br.com.dio.persistence.entity;

import lombok.Data;

import java.util.List;

@Data
public class ModuleEntity {
    private Long id;
    private String name;

    private List<EmployeeEntity> employees;

}
