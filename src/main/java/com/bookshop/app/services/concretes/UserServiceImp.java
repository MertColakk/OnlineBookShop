package com.bookshop.app.services.concretes;

import com.bookshop.app.models.User;
import com.bookshop.app.repositories.UserRepository;
import com.bookshop.app.services.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

    @Override
    public Boolean login(String email,String password){
        User user = userRepository.findByEmail(email);

        return bCryptPasswordEncoder.matches(password, user.getPassword());
    }

    @Override
    public User findUser(long id) {
        for(User user:userRepository.findAll()){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }
}
