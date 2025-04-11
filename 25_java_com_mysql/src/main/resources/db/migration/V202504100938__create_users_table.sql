CREATE TABLE users(
    id BIGINT not null auto_increment,
    name VARCHAR(100) not null,
    PRIMARY KEY(id)
)engine = InnoDB default charset=utf8;
