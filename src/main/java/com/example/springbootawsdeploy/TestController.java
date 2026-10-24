package com.example.springbootawsdeploy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login"; // Renders login.html
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        String username = (principal != null) ? principal.getName() : "Sakthivel";
        
        model.addAttribute("username", username);
        model.addAttribute("policyNumber", "POL-99482103");
        model.addAttribute("status", "ACTIVE");
        model.addAttribute("coverageType", "Comprehensive Health & Life");
        model.addAttribute("coverageAmount", "$500,000");

        return "dashboard"; // Renders dashboard.html
    }
}
