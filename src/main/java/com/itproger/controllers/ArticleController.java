package com.itproger.controllers;

import com.itproger.models.ArticleModel;
import com.itproger.models.User;
import com.itproger.repo.ArticleRepository;
import com.itproger.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final UserRepository userRepository;

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String showArticlePage(Model model,Principal principal) {
        model.addAttribute("article", new ArticleModel());
        User user = userRepository.findByUsername(principal.getName());
        Iterable<ArticleModel> listOfArticles = null;
        if(user != null){
          listOfArticles = articleRepository.findByUserId(user.getId());
        } else {
            listOfArticles = articleRepository.findAll();
        }
        model.addAttribute("listOfArticles",listOfArticles);
        return "/article/articlePage";
    }

    @PostMapping("/save")
    public String saveArticle(@ModelAttribute("article") ArticleModel article, Model model, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        ArticleModel articleModel = new ArticleModel(user.getId(), article.getTitle(), article.getText());
        articleRepository.save(articleModel);
        return "/article/articlePage";
    }

    @PostMapping("/edit/{id}")
    public String editArticle(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String text, Model model) throws ClassNotFoundException {
        ArticleModel articleModel = articleRepository.findById(id)
                .orElseThrow(ClassNotFoundException::new);
        articleModel.setTitle(title);
        articleModel.setText(text);
        articleRepository.save(articleModel);
        return "redirect:/article/articles";
    }

    @PostMapping("/delete/{id}")
    public String deleteArticle(@PathVariable(value = "id") long id, Model model) throws ClassNotFoundException {
        ArticleModel articleModel = articleRepository.findById(id)
                .orElseThrow(ClassNotFoundException::new);

        articleRepository.delete(articleModel);
        return "redirect:/article/articles";
    }
}
