package com.group05.abstractbusiness.utils.Validator;

import java.util.regex.Pattern;

public class EmailAndPasswordValidator {
    
    private static final String regexPattern = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@" 
    + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";
    
    public static Boolean verifyPassword(String password){
        if(password == null || password.isEmpty()) return false;
        else if(password.length() < 8) return false;
        else return true;
    }

    public static Boolean verifyEmail(String emailAddress) {
        return Pattern.compile(regexPattern)
          .matcher(emailAddress)
          .matches();
    }
    
}
