package com.bookshop.app.controllers;

import com.bookshop.app.models.Book;
import com.bookshop.app.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired BookController bookController;

    @GetMapping("/")
    public String home(Model model){

        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
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

    @GetMapping("/book/add")
    public String bookAdd(){

        return "bookAdd";
    }
}
