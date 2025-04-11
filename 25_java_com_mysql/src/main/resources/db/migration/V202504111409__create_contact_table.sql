CREATE TABLE contacts
(
    id BIGINT not null auto_increment,
    description VARCHAR(50) not null,
    type VARCHAR(30),
    employee_id BIGINT not null,
    PRIMARY KEY(id),
    CONSTRAINT fk_contacts_employee FOREIGN KEY (employee_id) REFERENCES employees(id)
)engine = InnoDB default charset=utf8;