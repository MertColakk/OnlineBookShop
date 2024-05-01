package com.bookshop.app.controllers;

import com.bookshop.app.models.Book;
import com.bookshop.app.models.User;
import com.bookshop.app.services.concretes.BookServiceImp;
import com.bookshop.app.services.concretes.CartServiceImp;
import com.bookshop.app.services.concretes.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/cart")
@CrossOrigin
public class CartController {
    @Autowired
    private CartServiceImp cartService;

    @Autowired
    private UserServiceImp userService;

    @Autowired
    private BookServiceImp bookService;


    @PostMapping("/add/{userID}/book/{bookID}")
    public ResponseEntity<List<Book>> addToCart(@PathVariable("userID")long userID, @PathVariable("bookID") long bookID) {
        User user = userService.findUser(userID);
        Book book = bookService.getWithID(bookID);
        cartService.addToCart(user, book);

        return new ResponseEntity<>(cartService.getCartItems(user), HttpStatus.OK);
    }

    @PostMapping("/remove/{userID}/book/{bookID}")
    public ResponseEntity<String> removeFromCart(@PathVariable("userID")long userID, @PathVariable("bookID")long bookID) {
        User user = userService.findUser(userID);
        Book book = bookService.getWithID(bookID);
        cartService.removeFromCart(user, book);

        return new ResponseEntity<>("Successfully removed!", HttpStatus.OK);
    }

    @GetMapping("{userID}/items")
    public ResponseEntity<List<Book>> getCartItems(@PathVariable("userID")long userID) {
        User user = userService.findUser(userID);
        List<Book> userBooks = cartService.getCartItems(user);
        return new ResponseEntity<>(userBooks, HttpStatus.OK);

    }
}
