package com.nagarro.qathon.service.impl;

import com.nagarro.qathon.Utility;
import com.nagarro.qathon.entity.User;
import com.nagarro.qathon.exceptionHandler.domain.UserNotFoundException;
import com.nagarro.qathon.repository.UserRepository;
import com.nagarro.qathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        user.setPassword(Utility.convertStringToAsciiValue(user.getPassword()));
        user.setEmail(Utility.convertStringToAsciiValue(user.getEmail()));
        return userRepository.save(user);
    }

    @Override
    public User login(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User fetchUserByEmailAndPassword(String email, String password) throws Exception {
        return this.userRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public User getUser(String email) throws Exception {
        return this.userRepository.findByEmail(email);
    }
}
