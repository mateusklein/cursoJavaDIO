CREATE TABLE accesses (
                          employee_id BIGINT NOT NULL,
                          module_id BIGINT NOT NULL,
                          PRIMARY KEY (employee_id, module_id),
                          CONSTRAINT fk_accesses_employees FOREIGN KEY (employee_id) REFERENCES employees(id),
                          CONSTRAINT fk_accesses_modulers FOREIGN KEY (module_id) REFERENCES modulers(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;