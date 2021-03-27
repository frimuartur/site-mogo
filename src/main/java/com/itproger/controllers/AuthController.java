package com.itproger.controllers;

import com.itproger.dto.UserDto;
import com.itproger.models.User;
import com.itproger.repo.UserRepository;
import com.itproger.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(path = "/auth")
public class AuthController {

    private final UserService userService;

    final UserRepository userRepository;

    public AuthController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "/auth/login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "/auth/registration";
    }

    @PostMapping("/registration")
    public String saveUser(UserDto userDto, Model model, RedirectAttributes redirAttrs) {
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            redirAttrs.addFlashAttribute("error", "Password doesn't coincide");
            return "redirect:/auth/registration";
        }

        User username = userRepository.findByUsername(userDto.getUsername());
        if (username != null) {
            redirAttrs.addFlashAttribute("error", "Username already in use");
            return "redirect:/auth/registration";
        }

        User userEmail = userRepository.findByEmail(userDto.getEmail());
        if (userEmail != null) {
            redirAttrs.addFlashAttribute("error", "Email already in use");
            return "redirect:/auth/registration";
        }

        userService.saveUser(userDto);

        return "/auth/login";
    }
}

