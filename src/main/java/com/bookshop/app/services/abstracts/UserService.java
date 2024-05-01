package com.bookshop.app.services.abstracts;

import com.bookshop.app.models.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User register(User user);
    Boolean login(String email,String password);
    User findUser(long id);
}
