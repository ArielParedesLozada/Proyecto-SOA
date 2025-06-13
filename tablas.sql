DROP TABLE usuarios;

CREATE TABLE IF NOT EXISTS usuarios (
    email VARCHAR(100) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    nombre_full VARCHAR(100) NOT NULL,
    role VARCHAR(25) NOT NULL
);

INSERT INTO usuarios VALUES (
    'admin@gmail.com',
    '$2a$10$9qM8mdTD7hz1yQUhIkWdG.4mRXv6tiCRZiPqsC6Km9K2YEQ31ic8G', --contraseña
    'Juan Paco Perez',
    'admin'
);