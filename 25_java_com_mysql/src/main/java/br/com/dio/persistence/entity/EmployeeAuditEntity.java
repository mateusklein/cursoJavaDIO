package br.com.dio.persistence.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record EmployeeAuditEntity(
                                          Long employee_id,
                                          String name,
                                          String old_name,
                                          BigDecimal salary,
                                          BigDecimal old_salary,
                                          OffsetDateTime birthday,
                                          OffsetDateTime old_birthday,
                                          OperationEnum operation
) {
}

