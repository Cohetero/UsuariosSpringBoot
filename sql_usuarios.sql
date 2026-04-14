SELECT * FROM USUARIOS;

CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    telefono VARCHAR(15),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO usuarios (nombre, email, password, telefono)
VALUES 
('Juan Perez', 'juan.perez@gmail.com', 'pass123', '2221234567'),

('Maria Lopez', 'maria.lopez@gmail.com', 'pass456', '2222345678'),

('Carlos Sanchez', 'carlos.sanchez@gmail.com', 'pass789', '2223456789'),

('Ana Torres', 'ana.torres@gmail.com', 'pass101', '2224567890'),

('Luis Hernandez', 'luis.hernandez@gmail.com', 'pass102', '2225678901'),

('Sofia Martinez', 'sofia.martinez@gmail.com', 'pass103', '2226789012'),

('Diego Ramirez', 'diego.ramirez@gmail.com', 'pass104', '2227890123'),

('Laura Gomez', 'laura.gomez@gmail.com', 'pass105', '2228901234'),

('Pedro Morales', 'pedro.morales@gmail.com', 'pass106', '2229012345'),

('Elena Castillo', 'elena.castillo@gmail.com', 'pass107', '2220123456');