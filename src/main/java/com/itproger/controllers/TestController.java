package com.itproger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/emailPage")
    public String showEmailPage(Model model) {
        model.addAttribute("object", new Object());   // Trimitem in view un obiect gol
        return "/emailPage";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(Model model, @ModelAttribute("object") Object obj) {
// Intoarcem din veiw obiectul obj plin
// Manipulam datele : salvam, redactam ecc
        return "/emailPage";
    }

}
