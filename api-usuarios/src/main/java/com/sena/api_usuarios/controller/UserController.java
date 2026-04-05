package com.sena.api_usuarios.controller;

import com.sena.api_usuarios.model.User;
import com.sena.api_usuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint para registrar un usuario
    // Recibe usuario y contraseña y los guarda en la base de datos
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        User newUser = userService.register(user);

        if (newUser == null) {
            return "El usuario ya existe";
        }

        return "Usuario registrado correctamente";
    }

    // Endpoint para iniciar sesión
    // Recibe usuario y contraseña y valida en la base de datos
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User loggedUser = userService.login(user);

        if (loggedUser != null) {
            return "Autenticación satisfactoria";
        }

        return "Error en la autenticación";
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Actualizar usuario
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {

        User updatedUser = userService.updateUser(id, user);

        if (updatedUser != null) {
            return "Usuario actualizado correctamente";
        }

        return "Usuario no encontrado";
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        boolean deleted = userService.deleteUser(id);

        if (deleted) {
            return "Usuario eliminado correctamente";
        }

        return "Usuario no encontrado";
    }
}
