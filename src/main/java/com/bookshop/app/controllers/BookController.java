package com.bookshop.app.controllers;

import com.bookshop.app.models.Book;
import com.bookshop.app.services.concretes.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    BookServiceImp bookService;

    @PostMapping("/add")
    public RedirectView addBook(@RequestParam String name,
                                @RequestParam int pageCount,
                                @RequestParam String author,
                                @RequestParam String publisher,
                                @RequestParam String genre,
                                @RequestParam double price) {
        bookService.add(name, pageCount, author, publisher, genre, price);
        return new RedirectView("/", true);
    }


    @GetMapping("/show")
    public ResponseEntity<List<Book>> show(){

        return new ResponseEntity<>(bookService.show(), HttpStatus.OK);
    }
}
