package com.nagarro.qathon.controller;
import com.nagarro.qathon.dto.EmailRequest;
import com.nagarro.qathon.entity.UserDetails;
import com.nagarro.qathon.exceptionHandler.ExceptionHandling;
import com.nagarro.qathon.exceptionHandler.domain.UserNotFoundException;
import com.nagarro.qathon.service.EmailSenderService;
import com.nagarro.qathon.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//springemailjune@gmail.com

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

    @PostMapping("/user/create")
    public UserDetails createUser(@RequestBody UserDetails userDetails){
        return userDetailsService.createUser(userDetails);
    }

    @PutMapping("/user/edit/{id}")
    public UserDetails updateUserDetails(@PathVariable("id") Long userId,
                                       @RequestBody UserDetails userDetails ) throws Exception {
        return userDetailsService.updateUserDetails(userId,userDetails);
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUserDetailsById(@PathVariable("id") Long userId) throws Exception {
        try {
            userDetailsService.deleteUserDetailsById(userId);
        }catch (Exception e){
            throw new UserNotFoundException("User Not Found for id = "+userId);
        }
        return "UserDetails deleted Successfully!!";
    }

    @PostMapping("/campaign")
    public ResponseEntity<?> sendCampaign(@RequestBody EmailRequest emailRequest){
        emailSenderService.sendCampaign(emailRequest.getToEmail(),emailRequest.getEmailBody(),emailRequest.getEmailSubject());
        return ResponseEntity.ok("Mail Sent Successfully");
    }

}
