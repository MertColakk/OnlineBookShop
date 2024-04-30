package com.bookshop.BookShopping.controllers;

import com.bookshop.BookShopping.entities.User;
import com.bookshop.BookShopping.services.concretes.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;

    @PostMapping("/register")
    ResponseEntity<User> register(@RequestBody User user){
        userServiceImp.register(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    ResponseEntity<Boolean> login(@RequestParam String email,@RequestParam String password){

        return new ResponseEntity<>(userServiceImp.login(email, password), HttpStatus.OK);
    }
}
