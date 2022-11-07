package com.mustache.bbs.controller;

import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mustache.bbs.domain.dto.ArticleDto;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value="/new")
    public String newArticleForm() {
        return "articles/new";
    }
    @PostMapping(value="/posts")
    public String createArticle(ArticleDto form) {
        // Dto를 Entity로 변환
        Article article = form.toEntity();
        log.info(form.toString());

        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "";
    }

}
