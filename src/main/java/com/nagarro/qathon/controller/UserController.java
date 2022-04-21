package com.nagarro.qathon.controller;
import com.nagarro.qathon.Utility;
import com.nagarro.qathon.entity.User;
import com.nagarro.qathon.entity.UserDetails;
import com.nagarro.qathon.exceptionHandler.ExceptionHandling;
import com.nagarro.qathon.exceptionHandler.domain.UserFoundException;
import com.nagarro.qathon.exceptionHandler.domain.UserNotFoundException;
import com.nagarro.qathon.service.EmailSenderService;
import com.nagarro.qathon.service.UserDetailsService;
import com.nagarro.qathon.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;


import javax.persistence.NoResultException;

import java.util.ArrayList;
import java.util.List;

import static com.nagarro.qathon.constant.UserImplConstant.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class UserController extends ExceptionHandling {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(UserController.class);


    @PostMapping("register")
    public ResponseEntity<User> registerUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        if(tempEmail != null && !"".equals(tempEmail)){
            User userobj = userService.getUser(Utility.convertStringToAsciiValue(tempEmail));
            if(userobj != null){
                throw new UserFoundException(USER_ALREADY_EXISTS + tempEmail);
            }
        }
        User userobj = null;
        userobj =  this.userService.register(user);
        return new ResponseEntity<>(userobj,OK);
    }
    @PostMapping("login")
    public ResponseEntity<User> loginUser(@RequestBody User user) throws Exception {
        String tempEmail =Utility.convertStringToAsciiValue(user.getEmail());
        String tempPassword = Utility.convertStringToAsciiValue(user.getPassword());

        User userObj = null;
        if(tempEmail!=null && tempPassword!=null){
            userObj=this.userService.fetchUserByEmailAndPassword(tempEmail,tempPassword);
        }
        if(userObj==null){
        throw new UserNotFoundException(NO_USER_FOUND_BY_EMAILANDPASSWORD);
        }
        return new ResponseEntity<>(userObj,OK);
    }


    @GetMapping("forgotpassword")
    public ResponseEntity<?> sendPassword(@RequestParam(name = "email") String userEmail) {
        try {
            User user = userService.getUser(Utility.convertStringToAsciiValue(userEmail));
            String password = Utility.convertAsciiToStringValue(user.getPassword());
            emailSenderService.sendForgetPasswordMail(userEmail, password);
            return new ResponseEntity<>("Mail Sent Successfully",OK);
        } catch (Exception e) {
            throw new NoResultException("User not found with this email : " + userEmail);
        }
    }

    @GetMapping("get-all-registered-users-for-backend")
    public List<User> getAllRegisteredUsers() {
       List<User> registeredUsers = userService.getAllRegisteredUsers();
       return registeredUsers;
    }

}
