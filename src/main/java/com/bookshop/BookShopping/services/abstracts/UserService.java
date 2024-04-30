package com.bookshop.BookShopping.services.abstracts;

import com.bookshop.BookShopping.entities.User;

public interface UserService {
    User register(User user);
    Boolean login(String email,String password);
}
