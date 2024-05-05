package com.learn.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learn.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    
    private UserRepository repository;
    private PasswordEncoder password;

    public RegistrationController(UserRepository repo, PasswordEncoder pe){
        this.repository = repo;
        this.password = pe;
    }

    @GetMapping
    public String registrationForm(){
        return "registration";
    }
    
    @PostMapping()
    public String processRegistration(RegistrationForm form) {
        repository.save(form.toUser(password));
        return "redirect:/login";
    }
    
}
