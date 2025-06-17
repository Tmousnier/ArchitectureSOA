package service;

import java.util.List;
import model.Article;

public interface CatalogueService {
    List<Article> getAllArticles();
    Article getArticleById(Long id);
    Article saveArticle(Article article);
    void deleteArticle(Long id);
}
