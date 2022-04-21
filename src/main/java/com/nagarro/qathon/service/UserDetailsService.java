package com.nagarro.qathon.service;

import com.nagarro.qathon.entity.UserDetails;

import java.util.List;

public interface UserDetailsService {
    public List<UserDetails> getAllUsersDetails();

    UserDetails updateUserDetails(Long userId, UserDetails userDetails) throws Exception;

    public void deleteUserDetailsById(Long userId) throws Exception;

    UserDetails createUser(UserDetails userDetails);

    public void saveAllUserDetails(List<UserDetails> userDetails);
}
