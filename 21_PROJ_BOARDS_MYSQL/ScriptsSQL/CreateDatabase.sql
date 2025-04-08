DROP SCHEMA MY_BOARDS;
USE MY_BOARDS;

CREATE TABLE Board (
                       board_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL
);

CREATE TABLE BoardColumn (
                             column_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             name VARCHAR(255) NOT NULL,
                             kind ENUM('INITIAL', 'FINAL', 'CANCEL', 'PENDING') NOT NULL,
                             `order` INT NOT NULL,
                             board_id BIGINT NOT NULL,
                             FOREIGN KEY (board_id) REFERENCES Board(board_id) ON DELETE CASCADE
);

CREATE TABLE Card (
                      card_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      title VARCHAR(255) NOT NULL,
                      description TEXT DEFAULT NULL,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      column_id BIGINT NOT NULL,
                      FOREIGN KEY (column_id) REFERENCES BoardColumn(column_id) ON DELETE CASCADE
);

CREATE TABLE Block (
                       block_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       block_cause TEXT DEFAULT NULL,
                       unblock_cause TEXT DEFAULT NULL,
                       block_in TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       unblock_in TIMESTAMP NULL DEFAULT NULL,
                       is_blocked TINYINT(1) DEFAULT 1,
                       card_id BIGINT NOT NULL,
                       FOREIGN KEY (card_id) REFERENCES Card(card_id) ON DELETE CASCADE
);