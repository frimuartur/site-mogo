package com.itproger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

//@Controller
public class TestController {

//    @PostMapping("/auth/login")
//    public String showInConsoleParametersForm (@RequestParam("username") String username,
//                                               @RequestParam("email") String email,
//                                               @RequestParam("password") String password,
//                                               @RequestParam("confirm_password") String confirm_password,
//                                               @RequestParam("phone") String phone,
//                                               @RequestParam("city") String city,
//                                               Model model) {
//
//        System.out.println("My username is: " + username);
//        System.out.println("My email is: " + email);
//        System.out.println("I'm from: " + city);
//        System.out.println("My tel is: " + phone);
//        System.out.println("My password is: " + password);
//        System.out.println("Confirm my password: " + confirm_password);
//        return "/auth/registration";
//    }


// NON COMPLETA   ===================================================================

//    @PostMapping("/auth/login")
//    public String showInConsoleParametersForm (HttpServletRequest request, Model model){
//        String username = request.getParameter("username");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String password = request.getParameter("password");
//        String confirm_password = request.getParameter("confirm_password");
//        String city = request.getParameter("city");
//
//        System.out.println("My username is: " + username);
//        System.out.println("My email is: " + email);
//        System.out.println("I'm from: " + city);
//        System.out.println("My tel is: " + phone);
//        System.out.println("My password is: " + password);
//        System.out.println("Confirm my password: " + confirm_password);
//        return "redirect:/auth/registration";
//    }
}
