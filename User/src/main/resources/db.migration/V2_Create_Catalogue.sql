CREATE TABLE IF NOT EXISTS catalogue
(
    id   int auto_increment
        primary key,
    nom  varchar(255) not null,
    prix int          not null
);