CREATE TABLE IF NOT EXISTS purchase
(
    id      SERIAL      PRIMARY KEY,
    product VARCHAR(50) NOT NULL,
    price   REAL        NOT NULL
);