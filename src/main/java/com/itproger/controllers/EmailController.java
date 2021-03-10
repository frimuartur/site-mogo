//package com.itproger.controllers;
//
//import com.itproger.models.ArticleModel;
//import com.itproger.models.EmailModel;
//import com.itproger.repo.EmailRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping()
//public class EmailController {
//
//    @Autowired
//    EmailRepository emailRepository;
//
//    @GetMapping("/email")
//    public String emailPage(Model model){
//        Iterable <EmailModel> allEmails = emailRepository.findAll();
//        model.addAttribute("allEmails", allEmails);
//        return "/email/email";
//    }
//
//    @PostMapping("/sendEmail")
//    public String sendEmail(@RequestParam String to, @RequestParam String subject,@RequestParam String text,Model model){
////        EmailModel email = new EmailModel(to,subject,text);
////        emailRepository.save(email);
//        return "/email/email";
//    }
//
//}
