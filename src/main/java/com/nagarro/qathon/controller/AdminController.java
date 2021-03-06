package com.nagarro.qathon.controller;
import com.nagarro.qathon.dto.EmailRequest;
import com.nagarro.qathon.entity.UserDetails;
import com.nagarro.qathon.exceptionHandler.ExceptionHandling;
import com.nagarro.qathon.exceptionHandler.domain.UserNotFoundException;
import com.nagarro.qathon.service.EmailSenderService;
import com.nagarro.qathon.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//springemailjune@gmail.com

import javax.persistence.NoResultException;
import java.util.List;

@RestController
@RequestMapping({"/dashboard"})
@CrossOrigin(origins = "*")
public class AdminController extends ExceptionHandling {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/users")
    public List<UserDetails> getUserDetails(){
        return userDetailsService.getAllUsersDetails();
    }

    @PostMapping("/krncky-17-user/create")
    public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails userDetails) throws Exception {
        try {
            UserDetails newUserDetails = userDetailsService.createUser(userDetails);
            return new ResponseEntity<UserDetails>(newUserDetails, HttpStatus.CREATED);
        }catch (Exception e) {
            throw new Exception("Something went wrong in create");
        }
    }

    @PutMapping("/krncky-17-user/edit/{id}")
    public ResponseEntity<?> updateUserDetails(@PathVariable("id") Long userId,
                                       @RequestBody UserDetails userDetails ) throws Exception {

        try {
            UserDetails updatedUserDetails = userDetailsService.updateUserDetails(userId, userDetails);
            return ResponseEntity.ok(updatedUserDetails);
        }catch (Exception e){
            throw new NoResultException("User Not Found for id = "+userId);
        }
    }

    @DeleteMapping("/krncky-17-user/delete/{id}")
    public ResponseEntity<?> deleteUserDetailsById(@PathVariable("id") Long userId) throws Exception {
        try {
            userDetailsService.deleteUserDetailsById(userId);
        }catch (Exception e){
            throw new NoResultException("User Not Found for id = "+userId);
        }
        return ResponseEntity.ok("UserDetails deleted Successfully!!");
    }

    @PostMapping("/campaign")
    public ResponseEntity<?> sendCampaign(@RequestBody EmailRequest emailRequest){
        emailSenderService.sendCampaign(emailRequest.getToEmail(),emailRequest.getEmailBody(),emailRequest.getEmailSubject());
        return ResponseEntity.ok("Mail Sent Successfully");
    }

}
