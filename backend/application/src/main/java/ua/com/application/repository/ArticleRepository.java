package ua.com.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.com.application.models.Article;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {
}
