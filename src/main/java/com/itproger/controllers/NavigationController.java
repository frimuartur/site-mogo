package com.itproger.controllers;

import com.itproger.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nav")
public class NavigationController {

    @GetMapping("/")
    public String home(Model model){
        return "/mogo/index";
    }

}
