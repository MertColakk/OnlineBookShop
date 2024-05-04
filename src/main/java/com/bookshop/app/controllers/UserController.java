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
    public ResponseEntity<Boolean> register
            (@RequestParam String firstName,
             @RequestParam String lastName,
             @RequestParam String email,
             @RequestParam String password,
             @RequestParam String confirmPassword,
             @RequestParam int age){

        boolean isRegistered = userService.register(firstName,lastName,email,password,confirmPassword,age);
        return new ResponseEntity<>(isRegistered, HttpStatus.OK);
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
