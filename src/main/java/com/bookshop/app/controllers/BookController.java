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

    @GetMapping("/get/{bookID}")
    public ResponseEntity<Book> get(@PathVariable("bookID")long bookID){

        return new ResponseEntity<>(bookService.getWithID(bookID),HttpStatus.OK);
    }

    @GetMapping("/show")
    public ResponseEntity<List<Book>> show(){

        return new ResponseEntity<>(bookService.show(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{bookID}")
    public ResponseEntity<Book> delete(@PathVariable("bookID")long bookID){
        Book book = bookService.getWithID(bookID);

        return new ResponseEntity<>(bookService.delete(book),HttpStatus.OK);
    }
}
