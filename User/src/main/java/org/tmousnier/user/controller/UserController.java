package org.tmousnier.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tmousnier.user.dao.User;
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
    public List<User> getCategories() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getCategoriesById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createCategory(@RequestBody UserInput userInput) {
        return userService.createUser(userInput);
    }

    @PutMapping("/{id}")
    public User updateCategory(@PathVariable String id, @RequestBody UserInput userInput) {
        return userService.updateUser(id, userInput);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
