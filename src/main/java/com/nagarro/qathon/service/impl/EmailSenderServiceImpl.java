package com.nagarro.qathon.service.impl;

import com.nagarro.qathon.entity.User;
import com.nagarro.qathon.exceptionHandler.domain.UserNotFoundException;
import com.nagarro.qathon.repository.UserRepository;
import com.nagarro.qathon.service.EmailSenderService;
import com.nagarro.qathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static com.nagarro.qathon.constant.UserImplConstant.NO_USER_FOUND_BY_EMAIL;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    @Value("${fromEmailAddress}")
    private String fromEmailAddress;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void sendCampaign(String toEmail, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmailAddress);
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
    }

    @Override
    public void sendForgetPasswordMail(String email, String password) {
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(email);
        smm.setSubject("Here Your Password");
        smm.setText(
                "You have requested your Email and password for the access of the QA-thon Application: \n\n"
                        + "Username: " + email + "\nPassword: " + password
                        + "\n\nPlease contact the nagarro team if you have any questions."
                        + "\n\nThank you,\nNagarro Team.");
        mailSender.send(smm);
    }
}
