package com.bookshop.app.controllers;

import com.bookshop.app.models.User;
import com.bookshop.app.services.concretes.CartServiceImp;
import com.bookshop.app.services.concretes.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserServiceImp userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        userService.register(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam String email,@RequestParam String password){
        boolean isLogined = userService.login(email, password);

        return new ResponseEntity<>(isLogined, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getByID(@PathVariable("id")long userID){

        return new ResponseEntity<>(userService.findUser(userID), HttpStatus.OK);
    }

}
