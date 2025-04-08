--liquibase formatted sql
--changeset mateus:202404041247
--comment: boards table create

CREATE TABLE BOARDS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
) ENGINE=InnoDB;


--rollback DROP TABLE BOARDS