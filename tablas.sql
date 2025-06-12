CREATE TABLE IF NOT EXISTS usuarios (
    email VARCHAR(100) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    nombreFull VARCHAR(100) NOT NULL,
    role VARCHAR(25) NOT NULL
);

INSERT INTO usuarios VALUES (
    'admin@admin.com',
    'contraseñabuena',
    'Juan Paco Perez',
    'admin'
);