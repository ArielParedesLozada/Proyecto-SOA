DROP TABLE usuarios;

CREATE TABLE IF NOT EXISTS usuarios (
    email VARCHAR(100) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    nombre_full VARCHAR(100) NOT NULL,
    role VARCHAR(25) NOT NULL
);

INSERT INTO usuarios VALUES (
    'admin@admin.com',
    '123456789',
    'Juan Paco Perez',
    'admin'
);

INSERT INTO usuarios VALUES (
    'secre@secre.com',
    '123456789',
    'Juana Paca Perez',
    'secretaria'
);