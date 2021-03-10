package com.itproger.controllers;

import com.itproger.models.Role;
import com.itproger.models.User;
import com.itproger.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model) {
        return "/auth/login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "/auth/registration";
    }

    @PostMapping("/auth/login")
    public String addUser(User user, Model model) {
        user.setEnabled(true);
        user.setRoles(Collections.singleton(Role.USER));

        String password = user.getPassword();
        String confirm_password = user.getConfirm_password();
        User username = userRepository.findByUsername(user.getUsername());
        User email = userRepository.findByEmail(user.getEmail());

        if(password.equals(confirm_password) && username == null && email == null) {
            userRepository.save(user);
            return "/auth/login";
        }
        return "/auth/registration";
    }

}

