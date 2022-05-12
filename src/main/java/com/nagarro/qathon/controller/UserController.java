package com.nagarro.qathon.controller;
import com.nagarro.qathon.Utility;
import com.nagarro.qathon.entity.User;
import com.nagarro.qathon.entity.UserDetails;
import com.nagarro.qathon.entity.UserStatistics;
import com.nagarro.qathon.exceptionHandler.ExceptionHandling;
import com.nagarro.qathon.exceptionHandler.domain.UserFoundException;
import com.nagarro.qathon.exceptionHandler.domain.UserNotFoundException;
import com.nagarro.qathon.repository.UserRepository;
import com.nagarro.qathon.repository.UserStatisticsRepository;
import com.nagarro.qathon.service.EmailSenderService;
import com.nagarro.qathon.service.UserDetailsService;
import com.nagarro.qathon.service.UserService;
import com.nagarro.qathon.service.impl.UserServiceImpl;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserStatisticsRepository userStatisticsRepository;

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
        UserStatistics userStatistics = userObj.getUserStatistics();
        userStatistics.setNewUsers((double) this.userRepository.count());
        this.userStatisticsRepository.save(userStatistics);
        this.userRepository.save(userObj);

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

    @GetMapping("krncky-17-get-all-registered-users-for-backend")
    public List<User> getAllRegisteredUsers() {
       List<User> registeredUsers = userService.getAllRegisteredUsers();
       return registeredUsers;
    }


//    @GetMapping("get-new-users")
//    public Long getNewUsers() {
//        Long  = userService.getAllRegisteredUsers().stream().count();
//        return registeredUsers;
//    }

    @GetMapping("user/credit-score")
    public User updateCreditScore(@RequestParam(name = "email") String userEmail, @RequestParam(name = "credit_score") Double creditScore) throws Exception,StackOverflowError {
        try {
            User user = userService.getUser(Utility.convertStringToAsciiValue(userEmail));
            UserStatistics userStatistics = user.getUserStatistics();
            userStatistics.setCreditScore(creditScore);
            this.userStatisticsRepository.save(userStatistics);
            this.userRepository.save(user);
            return user;
        }catch (Exception e){
            throw new NoResultException("User Not Found for this email = "+userEmail);
        }
    }


//    @GetMapping("user/findByFirstName/{firstname}")
//    public List<User> findByFirstnameIgnoreCase(@PathVariable("firstname") String firstname) {
//        try {
//            List<User> users = this.userService.findByFirstnameIgnoreCase(firstname);
//            return users;
//        }catch (Exception e){
//            throw new NoResultException("User Not Found for this firstname = "+firstname);
//        }
//    }

    @GetMapping("krncky-17-user/findByEmail/{email}")
    public User findUserByEmail(@PathVariable("email") String email){
        try {
            User user = this.userRepository.findByEmail(Utility.convertStringToAsciiValue(email));
            return user;
        }catch (Exception e){
            throw new NoResultException("User Not Found for this email = "+email);
        }
    }

    @DeleteMapping(value = "krncky-17-user/delete-registered-user-by-id/{id}")
    public String deleteRegisteredUsersFromBackend(@PathVariable("id") long id) throws Exception {
        try {
            this.userRepository.deleteById(id);
        }catch (Exception e){
            throw new NoResultException("User Not Found for id = "+id);
        }
        return "Registered User deleted successfully";
    }

    @DeleteMapping("krncky-17-user/delete-registered-user-by-email-encrypted/{email}")
    public User deleteUserByEmailEncrypted(@PathVariable("email") String email){
        try {
            User user = this.userRepository.findByEmail(email);
            this.userRepository.delete(user);
            return user;
        }catch (Exception e){
            throw new NoResultException("User Not Found for this email = "+Utility.convertAsciiToStringValue(email));
        }
    }

    @DeleteMapping("krncky-17-user/delete-registered-user-by-email/{email}")
    public User deleteUserByEmail(@PathVariable("email") String email){
        try {
            User user = this.userRepository.findByEmail(Utility.convertStringToAsciiValue(email));
            this.userRepository.delete(user);
            return user;
        }catch (Exception e){
            throw new NoResultException("User Not Found for this email = "+email);
        }
    }

    @GetMapping("krncky-17-user/convert-ascii-to-string/{email}")
    public String convertAsciiToStringValue(@PathVariable("email") String email) {
        return Utility.convertAsciiToStringValue(email);
    }
}
