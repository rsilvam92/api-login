-- Crear base de datos
CREATE DATABASE api_login;

-- Usar base de datos
USE api_login;

-- Crear tabla usuarios
CREATE TABLE usuarios (
      id INT AUTO_INCREMENT PRIMARY KEY,
      username VARCHAR(50) NOT NULL UNIQUE,
      password VARCHAR(255) NOT NULL,
      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);