package com.nagarro.qathon.service;

import com.nagarro.qathon.entity.User;
import com.nagarro.qathon.exceptionHandler.domain.UserNotFoundException;

public interface EmailSenderService {
    public void sendCampaign(String toEmail,
                             String body,
                             String subject);

    public void sendForgetPasswordMail(String email, String password);

}
