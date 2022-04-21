package com.nagarro.qathon;

import com.nagarro.qathon.entity.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utility {
    public static String getSiteURL(HttpServletRequest request){

        String siteURL = request.getRequestURL().toString();
        return siteURL;
    }

    public static String convertStringToAsciiValue(String password){
        String encodedPassword = "";
        for (int index = 0; index < password.length(); index++) {
            encodedPassword += (int)password.charAt(index);
        }
        System.out.println("encoded password is : " + encodedPassword);
        return encodedPassword;
    }
    public static String convertAsciiToStringValue(String encodedPassword) {
        int num = 0;
        int len = encodedPassword.length();
        String password = "";
        for (int i = 0; i < len; i++) {
            num = num * 10 + (encodedPassword.charAt(i) - '0');
            if (num >= 32 && num <= 122) {
                char ch = (char)num;
                password = password + ch;
                num = 0;
            }
        }
        return password;
    }

    public static int generateIntRandomNumber(int low,int high){
        Random random = new Random();
        int randomNumber = random.nextInt(high-low) + low;
        return randomNumber;
    }

}
