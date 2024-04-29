package com.bookshop.BookShopping.services.concretes;

import com.bookshop.BookShopping.entities.User;
import com.bookshop.BookShopping.repository.abstracts.UserRepository;
import com.bookshop.BookShopping.services.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public User register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return user;
    }
}
