package org.tmousnier.user.service;

import org.springframework.stereotype.Service;
import org.tmousnier.user.dao.User;
import org.tmousnier.user.dto.UserInput;
import org.tmousnier.user.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User createUser(UserInput userInput) {
        User newUser = User.builder()
                .email(userInput.email())
                .password(userInput.password())
                .build();
        return userRepository.save(newUser);
    }

    public User updateUser(String id, UserInput userInput) {
        User user = userRepository.findById(id).orElseThrow();

        user.setEmail(userInput.email());
        user.setPassword(userInput.password());

        return userRepository.save(user);
    }

    public User deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        return user;
    }

}
