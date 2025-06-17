package org.example.catalogue.service;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.example.catalogue.dto.CatalogueInput;
import org.example.catalogue.model.Catalogue;
import org.example.catalogue.repository.CatalogueRepository;
import org.springframework.stereotype.Service;

@Service
public class CatalogueService {
    private final CatalogueRepository catalogueReposiotry;

    public CatalogueService(CatalogueRepository catalogueReposiotry) {
        this.catalogueReposiotry = catalogueReposiotry;
    }

    public List<Catalogue> getCatalogues() {
        return catalogueReposiotry.findAll();
    }

    public Catalogue getCatalogueById(Long id) {
        return catalogueReposiotry.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Catologue non trouvé avec l'id : " + id));    }

    public Catalogue createCatalogue(CatalogueInput catalogueInput) {
        if (catalogueReposiotry.findCatalogueByNom(catalogueInput.nom()).isPresent()) {
            throw new IllegalArgumentException("Un utilisateur avec cet email existe déjà.");
        }
        Catalogue newCatalogue = Catalogue.builder()
                .nom(catalogueInput.nom())
                .prix(catalogueInput.prix())
                .build();
        return catalogueReposiotry.save(newCatalogue);
    }

    public Catalogue updateCatalogue(Long id, CatalogueInput catalogueInput) {
        Catalogue catalogue = catalogueReposiotry.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Catalogue non trouvé avec l'id : " + id));

        catalogue.setPrix(catalogueInput.prix());
        catalogue.setNom(catalogueInput.nom());

        return catalogueReposiotry.save(catalogue);
    }

    public void deleteCatalogue(Long id) {
        Catalogue catalogue = catalogueReposiotry.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'id : " + id));
        catalogueReposiotry.delete(catalogue);
    }

}
