--liquibase formatted sql
--changeset mateus:202404041438
--comment: BLOCKS table create

CREATE TABLE BLOCKS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    blocked_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    block_reason VARCHAR(255) NOT NULL,
    unblocked_at TIMESTAMP null,
    unblock_reason VARCHAR(255) NULL,
    card_id BIGINT NOT NULL,
    CONSTRAINT cards_blocks_fk FOREIGN KEY (card_id) REFERENCES CARDS(id) ON DELETE CASCADE
) ENGINE=InnoDB;


--rollback DROP TABLE BLOCKS