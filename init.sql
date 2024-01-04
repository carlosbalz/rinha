CREATE TABLE IF NOT EXISTS pessoa (
    id          SERIAL PRIMARY KEY,
    apelido     VARCHAR(32) NOT NULL UNIQUE,
    nome        VARCHAR(100) NOT NULL,
    nascimento  VARCHAR(10) NOT NULL,
    stack       VARCHAR(32)[]
);