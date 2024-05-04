package com.bookshop.app.services.abstracts;

import com.bookshop.app.models.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User register(User user);
    Boolean login(String email,String password);
    User findUser(long id);

    //After
    User changePassword(User user,String newPassword);
    User changeFirstName(User user,String newFirstName);
    User changeLastName(User user,String newLastName);
    User changeMail(User user,String newMail);
    User changeAge(User user,int newAge);

}
