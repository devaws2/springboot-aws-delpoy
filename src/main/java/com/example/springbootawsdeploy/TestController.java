package com.example.springbootawsdeploy;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping({"/", "/demo/data", "/dashboard"})
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails, Model model, UserRepository userRepository) {
        if (userDetails != null) {
            userRepository.findByUsername(userDetails.getUsername()).ifPresent(user -> {
                model.addAttribute("fullName", user.getFullName());
                model.addAttribute("policyNumber", user.getPolicyNumber());
                model.addAttribute("email", user.getUsername());
            });
        }
        return "dashboard";
    }
}
