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
    public Boolean register(String firstName,String lastName,String email,String password,String passwordAgain,int age) {
        if(password.equals(passwordAgain) && checkEmail(email) && age >= 18){
            User user = new User(firstName,lastName,email,password,age);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean login(String email,String password){
        User user = userRepository.findByEmail(email);

        return user!=null && bCryptPasswordEncoder.matches(password, user.getPassword());
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

    public Boolean checkEmail(String email){
        for(User user: userRepository.findAll()){
            if(user.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }
}
