package org.tmousnier.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserInput (
        @NotBlank(message = "L'email ne peut pas être vide.")
        @Email(message = "Format d'email invalide.")
        String email,

        @NotBlank(message = "Le mot de passe ne peut pas être vide.")
        String password
) {}
