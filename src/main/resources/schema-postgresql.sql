CREATE TABLE IF NOT EXISTS jogos (
    id serial PRIMARY KEY,
    nome varchar(50),
    plataforma varchar(20),
    zerado boolean
);