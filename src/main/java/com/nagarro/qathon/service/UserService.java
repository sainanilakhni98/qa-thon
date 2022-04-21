package com.nagarro.qathon.service;

import com.nagarro.qathon.entity.User;
import com.nagarro.qathon.entity.UserDetails;

import java.util.List;

public interface UserService {
    public User register(User user);
    public User login(String email);
    public User fetchUserByEmailAndPassword(String email, String password) throws Exception;
    public User getUser(String email) throws Exception;

    public List<User> getAllRegisteredUsers();
}
