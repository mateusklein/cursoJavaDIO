--liquibase formatted sql
--changeset mateus:202404041434
--comment: CARDS table create

CREATE TABLE CARDS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    board_column_id BIGINT NOT NULL,
    CONSTRAINT boards_columns_cards_fk FOREIGN KEY (board_column_id) REFERENCES BOARDS_COLUMNS(id) ON DELETE CASCADE
) ENGINE=InnoDB;


--rollback DROP TABLE CARDS