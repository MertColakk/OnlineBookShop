package com.bookshop.BookShopping.webApi;

import com.bookshop.BookShopping.business.concretes.CartServiceImp;
import com.bookshop.BookShopping.entities.Book;
import com.bookshop.BookShopping.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartServiceImp cartServiceImp;

    @PostMapping("{id}")
    public ResponseEntity<Boolean> add(@RequestBody int id){
        cartServiceImp.addToCart(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
