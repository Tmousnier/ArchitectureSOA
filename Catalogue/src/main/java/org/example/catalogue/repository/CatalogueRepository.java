package org.example.catalogue.repository;

import org.example.catalogue.model.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {
    Optional<Catalogue> findCatalogueByNom(String nom);
}
