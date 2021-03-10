package com.itproger.controllers;

import com.itproger.models.ArticleModel;
import com.itproger.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public String ShowArticles(Model model) {
//        Iterable<ArticleModel> allArticles = articleRepository.findAll();
//        model.addAttribute("allArticles", allArticles);
        return "/article/my-articles";
    }

    @GetMapping("/all-articles")
    public String showAllArticles (Model model) {
//        Iterable<ArticleModel> allArticles = articleRepository.findAll();
//        model.addAttribute("allArticles", allArticles);
        return "/article/all-articles";
    }

    @PostMapping("/update/{id}")
    public String updateArticle(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String text, Model model) throws ClassNotFoundException {
        ArticleModel articleModel = articleRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException());
        articleModel.setTitle(title);
        articleModel.setText(text);
        articleRepository.save(articleModel);

        return "redirect:/article/my-articles";
    }

    @PostMapping("/save")
    public String saveArticle(@RequestParam String title, @RequestParam String text, Model model) {
        ArticleModel article = new ArticleModel(text, title);
        articleRepository.save(article);
        return "redirect:/article/my-articles";
    }

    @PostMapping("/delete/{id}")
    public String deleteArticle(@PathVariable(value = "id") long id, Model model) throws ClassNotFoundException {
        ArticleModel articleModel = articleRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException());

        articleRepository.delete(articleModel);
        return "redirect:/article/my-articles";
    }
}
