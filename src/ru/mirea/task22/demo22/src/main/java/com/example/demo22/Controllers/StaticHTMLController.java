package com.example.demo22.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticHTMLController {
    @RequestMapping(value = "/home")
    public String getTestPage() {
        return "home";
    }
}
