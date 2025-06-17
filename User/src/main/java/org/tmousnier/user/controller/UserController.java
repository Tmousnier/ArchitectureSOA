package org.tmousnier.user.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tmousnier.user.dao.Utilisateur;
import org.tmousnier.user.dto.UserInput;
import org.tmousnier.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Utilisateur> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public Utilisateur getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public Utilisateur createUser(@RequestBody UserInput userInput) {
        return userService.createUser(userInput);
    }

    @PutMapping("/{id}")
    public Utilisateur updateUser(@PathVariable String id, @Valid @RequestBody UserInput userInput) {
        return userService.updateUser(id, userInput);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
