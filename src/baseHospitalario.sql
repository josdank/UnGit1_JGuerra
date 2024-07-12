-- Crear base de datos
CREATE DATABASE sistema_hospitalario;
USE sistema_hospitalario;

-- Crear tabla USUARIO
CREATE TABLE USUARIO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);
CREATE TABLE PACIENTE (
    cedula VARCHAR(10) PRIMARY KEY,
    n_historial_clinico INT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    telefono VARCHAR(15),
    edad INT,
    descripcion_enfermedad TEXT
);

Select *From USUARIO;
Select *From PACIENTE;

-- Insertar registros en la tabla USUARIO
INSERT INTO USUARIO (username, password) 
VALUES 
('Juanito', 'Juanito123'),
('Sofia', 'Sofia123'),
('Lili', 'Lili123');


INSERT INTO PACIENTE (cedula, n_historial_clinico, nombre, apellido, telefono, edad, descripcion_enfermedad) 
VALUES 
('1723456789', 124, 'Juan', 'Perez', '0987654321', 45, 'Diabetes tipo 2'),
('0928765432', 125, 'Maria', 'Gomez', '0123456789', 35, 'Hipertensión arterial'),
('1122334455', 126, 'Carlos', 'Lopez', '0234567890', 50, 'Cáncer de colon');

