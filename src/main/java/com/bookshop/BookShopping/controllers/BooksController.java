package com.bookshop.BookShopping.controllers;

import com.bookshop.BookShopping.services.concretes.BookServiceImp;
import com.bookshop.BookShopping.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BooksController {
    @Autowired
    private BookServiceImp bookServiceImp;

    @PostMapping("/add")
    public ResponseEntity<Book> add(@RequestBody Book book){
        bookServiceImp.addBook(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAll(){
        List<Book> bookList = bookServiceImp.getBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Book>> getWithID(@PathVariable("id") long bookID){
        Optional<Book> book = bookServiceImp.getWithID(bookID);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@RequestParam String bookName){
        boolean isDeleted = bookServiceImp.deleteBook(bookName);

        if(isDeleted){
            return new ResponseEntity<>(bookName+" successfully deleted!", HttpStatus.OK);
        }
        return new ResponseEntity<>("There is an error while deleting the "+bookName, HttpStatus.METHOD_NOT_ALLOWED);
    }

}
