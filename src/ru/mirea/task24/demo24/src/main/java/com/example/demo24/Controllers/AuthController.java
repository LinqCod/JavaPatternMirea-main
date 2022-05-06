package com.example.demo24.Controllers;

import com.example.demo24.services.UserAppService;
import com.example.demo24.tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserAppService userAppService;

    @Autowired
    public AuthController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }



    @GetMapping("/web-home")
    public String getIndexPage() {
        return "home";
    }

    /**
     * @ModelAttribute — аннотация, которая связывает параметр метода или
     * возвращаемое значение метода с именованным атрибутом модели, а затем предоставляет его веб-представлению.
     * */

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String signUpUser(@ModelAttribute("user") User user) {
        return userAppService.signUpUser(user);
    }
}
