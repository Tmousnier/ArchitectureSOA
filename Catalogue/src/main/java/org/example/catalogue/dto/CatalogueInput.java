package org.example.catalogue.dto;

public record CatalogueInput (
        int prix,
        String nom
) {
    public CatalogueInput {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Nom cannot be null or blank");
        }
        if (prix <= 0) {
            throw new IllegalArgumentException("Prix must be greater than zero");
        }
    }
}
