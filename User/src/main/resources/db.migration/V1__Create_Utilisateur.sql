CREATE TABLE IF NOT EXISTS utilisateur
(
    uuid     varchar(100) not null primary key,
    email    varchar(255) not null,
    password varchar(255) not null
);

