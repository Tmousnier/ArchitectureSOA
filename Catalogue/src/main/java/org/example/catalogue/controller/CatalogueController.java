package org.example.catalogue.controller;

import org.example.catalogue.model.Article;
import org.example.catalogue.service.CatalogueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogue")
public class CatalogueController {

    private final CatalogueService catalogueService;

    public CatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return catalogueService.getAllArticles();
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return catalogueService.saveArticle(article);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}
