package com.nagarro.qathon.service.impl;

import com.nagarro.qathon.entity.UserDetails;
import com.nagarro.qathon.exceptionHandler.domain.UserNotFoundException;
import com.nagarro.qathon.repository.UserDetailRepository;
import com.nagarro.qathon.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public List<UserDetails> getAllUsersDetails() {
        return userDetailRepository.findAll();
    }

    @Override
    public UserDetails updateUserDetails(Long userId, UserDetails userDetails) throws Exception {
        try {
            UserDetails userDetailsDb = userDetailRepository.findById(userId).get();

            if(Objects.nonNull(userDetails.getName()) && !"".equalsIgnoreCase(userDetails.getName())){
                userDetailsDb.setName(userDetails.getName());
            }
            if(Objects.nonNull(userDetails.getCompany()) && !"".equalsIgnoreCase(userDetails.getCompany())){
                userDetailsDb.setCompany(userDetails.getCompany());
            }
            if(Objects.nonNull(userDetails.getRole()) && !"".equalsIgnoreCase(userDetails.getRole())){
                userDetailsDb.setRole(userDetails.getRole());
            }
            if(Objects.nonNull(userDetails.getVerified()) && !"".equalsIgnoreCase(userDetails.getVerified()) ){
                userDetailsDb.setVerified(userDetails.getVerified());
            }
            if(Objects.nonNull(userDetails.getStatus()) && !"".equalsIgnoreCase(userDetails.getStatus()) ){
                userDetailsDb.setStatus(userDetails.getStatus());
            }
            return userDetailRepository.save(userDetailsDb);
        }
        catch(Exception e){
            throw new Exception("Method Not Allowed");
        }

    }
    @Override
    public void deleteUserDetailsById(Long userId) throws Exception {

        userDetailRepository.deleteById(userId);

    }
    @Override
    public UserDetails createUser(UserDetails userDetails) {
        return userDetailRepository.save(userDetails);
    }


    @Override
    public void saveAllUserDetails(List<UserDetails> userDetails){
        this.userDetailRepository.saveAll(userDetails);
    }
}
