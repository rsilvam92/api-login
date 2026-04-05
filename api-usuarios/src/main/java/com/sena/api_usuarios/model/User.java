package com.sena.api_usuarios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

// Clase que representa la entidad Usuario en la base de datos
// Esta clase se mapea con la tabla "usuarios"
@Entity
@Table(name = "usuarios")
public class User {

    // Identificador único del usuario (clave primaria)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre de usuario (no puede repetirse)
    @Column(unique = true, nullable = false)
    private String username;

    // Contraseña del usuario
    @Column(nullable = false)
    private String password;

    // Fecha de creación del usuario
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters y Setters
    public Long getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}