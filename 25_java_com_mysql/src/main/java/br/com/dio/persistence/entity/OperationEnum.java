package br.com.dio.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum OperationEnum {
    INSERT,
    UPDATE,
    DELETE ;

    public static OperationEnum getByDbOperation(String dbOperation) {
        return Stream.of(OperationEnum.values()).filter(o -> o.name().startsWith(dbOperation.toUpperCase()))
                .findFirst().orElseThrow();
    }

}
