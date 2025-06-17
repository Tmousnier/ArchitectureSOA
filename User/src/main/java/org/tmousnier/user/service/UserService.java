package org.tmousnier.user.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.tmousnier.user.dao.Utilisateur;
import org.tmousnier.user.dto.UserInput;
import org.tmousnier.user.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Utilisateur> getUsers() {
        return userRepository.findAll();
    }

    public Utilisateur getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'id : " + id));
    }

    public Utilisateur createUser(UserInput userInput) {
        if (userRepository.findByEmail(userInput.email()).isPresent()) {
            throw new IllegalArgumentException("Un utilisateur avec cet email existe déjà.");
        }

        String hashedPassword = passwordEncoder.encode(userInput.password());
        Utilisateur newUser = Utilisateur.builder()
                .email(userInput.email())
                .password(hashedPassword)
                .build();
        return userRepository.save(newUser);
    }

    public Utilisateur updateUser(String id, UserInput userInput) {
        Utilisateur user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'id : " + id));

        user.setEmail(userInput.email());
        user.setPassword(passwordEncoder.encode(userInput.password()));

        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        Utilisateur user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'id : " + id));
        userRepository.delete(user);
    }
}
