package com.bookshop.app.services.concretes;

import com.bookshop.app.models.User;
import com.bookshop.app.repositories.UserRepository;
import com.bookshop.app.services.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public User register(User user) {
        if(!userRepository.findAll().contains(user)){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }

        return user;
    }

    @Override
    public Boolean login(@RequestParam("mail") String email,@RequestParam("password") String password){
        User user = userRepository.findByEmail(email);
        if(user != null && bCryptPasswordEncoder.matches(password, user.getPassword()) && user.getEmail().equals(email)){
            return true;
        }
        return false;
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

    @Override
    public User changePassword(User user,String newPassword) {
        user.setPassword(bCryptPasswordEncoder.encode(newPassword));

        return user;
    }

    @Override
    public User changeFirstName(User user, String newFirstName) {
        user.setFirstName(newFirstName);

        return user;
    }

    @Override
    public User changeLastName(User user, String newLastName) {
        user.setLastName(newLastName);

        return user;
    }

    @Override
    public User changeMail(User user, String newMail) {
        user.setEmail(newMail);

        return user;
    }

    @Override
    public User changeAge(User user, int newAge) {
        user.setAge(newAge);

        return user;
    }
}
