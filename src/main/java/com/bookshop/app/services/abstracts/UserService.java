package com.bookshop.app.services.abstracts;

import com.bookshop.app.models.User;

import java.util.Date;


public interface UserService {
    Boolean register(String firstName, String lastName, String email, String password, String passwordAgain, int age);
    Boolean login(String email,String password);
    User findUser(long id);
}
