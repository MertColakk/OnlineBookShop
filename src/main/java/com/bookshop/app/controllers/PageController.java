package com.bookshop.app.controllers;

import com.bookshop.app.services.concretes.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    @Autowired
    private UserServiceImp userService;

    @GetMapping("/user/login")
    String greetingPage(ModelMap map,@RequestParam(required = true) String mail,@RequestParam(required = true) String password) {
        System.out.println(userService.login(mail,password));

        return "home";
    }
}
