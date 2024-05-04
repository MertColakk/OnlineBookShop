package com.bookshop.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(){

        return "home";
    }

    @GetMapping("/user/login")
    public String login(){

        return "login";
    }

    @GetMapping("/user/register")
    public String register(){

        return "register";
    }
}
