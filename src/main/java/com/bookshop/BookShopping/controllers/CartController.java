package com.bookshop.BookShopping.controllers;

import com.bookshop.BookShopping.entities.Book;
import com.bookshop.BookShopping.services.concretes.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartServiceImp cartServiceImp;

    @PostMapping("/add/{id}")
    public ResponseEntity<String> add(@PathVariable("id") long id){
        cartServiceImp.addToCart(id);
        return new ResponseEntity<>("Sucessfully added to cart!", HttpStatus.OK);
    }

    @GetMapping("/show")
    public ResponseEntity<List<Book>> show(){
        List<Book> books = cartServiceImp.showAllCart();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/totalCost")
    public ResponseEntity<Double> showCost(){
        double cost = cartServiceImp.getTotalCost();
        return new ResponseEntity<>(cost, HttpStatus.OK);
    }
}
