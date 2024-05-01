package com.bookshop.app.controllers;

import com.bookshop.app.models.Book;
import com.bookshop.app.services.concretes.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    BookServiceImp bookService;

    @PostMapping("/add")
    public ResponseEntity<Book> add(@RequestBody Book book){
        bookService.add(book);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/show")
    public ResponseEntity<List<Book>> show(){

        return new ResponseEntity<>(bookService.show(), HttpStatus.OK);
    }
}
