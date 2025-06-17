package org.example.catalogue.controller;

import jakarta.validation.Valid;
import org.example.catalogue.dto.CatalogueInput;
import org.example.catalogue.model.Catalogue;
import org.example.catalogue.service.CatalogueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalogue")
public class CatalogueController {

    private final CatalogueService catalogueService;

    public CatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @GetMapping
    public List<Catalogue> getCatalogue() {
        return catalogueService.getCatalogues();
    }

    @GetMapping("/{id}")
    public Catalogue getCatalogueById(@PathVariable Long id) {
        return catalogueService.getCatalogueById(id);
    }

    @PostMapping
    public Catalogue createUser(@RequestBody CatalogueInput catalogueInput) {
        return catalogueService.createCatalogue(catalogueInput);
    }

    @PutMapping("/{id}")
    public Catalogue updateUser(@PathVariable Long id, @Valid @RequestBody CatalogueInput catalogueInput) {
        return catalogueService.updateCatalogue(id, catalogueInput);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        catalogueService.deleteCatalogue(id);
    }

}
