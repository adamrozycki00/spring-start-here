CREATE TABLE IF NOT EXISTS account
(
    id      INT         NOT NULL    AUTO_INCREMENT  PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    amount  DOUBLE      NOT NULL
);