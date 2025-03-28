CREATE TABLE IF NOT EXISTS pessoa (
    id          uuid NOT NULL,
    apelido     VARCHAR(32) NOT NULL UNIQUE,
    nome        VARCHAR(100) NOT NULL,
    nascimento  VARCHAR(10) NOT NULL,
    stack       TEXT[],
    termo       character varying(500) GENERATED ALWAYS AS (apelido || ' ' || nome || ' ' || nascimento) STORED
);

CREATE EXTENSION IF NOT EXISTS pg_trgm;

CREATE INDEX ON pessoa USING gist(termo gist_trgm_ops);