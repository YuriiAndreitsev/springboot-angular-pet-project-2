package ua.com.application.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import ua.com.application.dto.ArticleAuthorDTO;
import ua.com.application.models.Article;
import ua.com.application.repository.ArticleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    public ArticleService(ArticleRepository articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
    }

    public List<ArticleAuthorDTO> getAllArticlesDTO() {
        return articleRepository.findAll().stream()
                .map(this::convertArticleToAuthorArticleDTO)
                .collect(Collectors.toList());

    }

    private ArticleAuthorDTO convertArticleToAuthorArticleDTO(Article article) {
        return modelMapper.map(article, ArticleAuthorDTO.class);
    }

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }
}
