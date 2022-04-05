package com.nagarro.qathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {

    //this is email property
    private String toEmail;
    private String emailSubject;
    private String emailBody;

}
