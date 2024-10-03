package com.votingsystem.controller;



import com.votingsystem.model.User;
import com.votingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/admin/activate/{userId}")
    public String activateUser(@PathVariable int userId) {
        userService.activateUser(userId);
        return "redirect:/admin/dashboard";
    }
    
   
}
