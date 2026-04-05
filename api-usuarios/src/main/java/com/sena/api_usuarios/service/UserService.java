package com.sena.api_usuarios.service;

import com.sena.api_usuarios.model.User;
import com.sena.api_usuarios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Método para registrar un nuevo usuario
    public User register(User user) {

        // Buscar si el usuario ya existe
        User existingUser = userRepository.findByUsername(user.getUsername()).orElse(null);

        // Validar si ya existe
        if (existingUser != null) {
            System.out.println("El usuario ya existe");
            return null;
        }

        // Guardar usuario en la base de datos
        return userRepository.save(user);
    }

    // Método para validar el login del usuario
    public User login(User user) {

        // Buscar usuario en la base de datos
        User existingUser = userRepository.findByUsername(user.getUsername()).orElse(null);

        // Validar si existe y si la contraseña coincide
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return existingUser;
        }

        // Si no cumple, retorna null
        return null;
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Obtener usuario por ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Actualizar usuario
    public User updateUser(Long id, User user) {

        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            return userRepository.save(existingUser);
        }

        return null;
    }

    // Eliminar usuario
    public boolean deleteUser(Long id) {

        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            userRepository.delete(existingUser);
            return true;
        }

        return false;
    }
}