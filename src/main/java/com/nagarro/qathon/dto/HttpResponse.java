package com.nagarro.qathon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@NoArgsConstructor
public class HttpResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
    private Date timestamp;
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private String reason;
    private String message;

    public HttpResponse(int httpStatusCode, HttpStatus httpStatus, String reason, String message) {
        this.timestamp = new Date();
        this.httpStatusCode = httpStatusCode;
        this.httpStatus = httpStatus;
        this.reason = reason;
        this.message = message;
    }
}
