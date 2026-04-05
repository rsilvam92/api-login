package com.sena.api_usuarios.repository;

import com.sena.api_usuarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// Interfaz que permite acceder a la base de datos
// Extiende JpaRepository para usar métodos ya creados (guardar, buscar, eliminar)
public interface UserRepository extends JpaRepository<User, Long> {

    // Método para buscar un usuario por su nombre de usuario
    // Se usa en el login y en el registro
    Optional<User> findByUsername(String username);
}
