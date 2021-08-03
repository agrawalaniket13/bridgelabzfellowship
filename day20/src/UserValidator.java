package com.day201;

import java.util.regex.Pattern;

public class UserValidator {
    private static final String FIRST_NAME_PATTERN="^[A-Z]{1}[a-z]{2,}$";
    private static final String LAST_NAME_PATTERN="^[A-Z]{1}[a-z]{2,}$";
    private static final String MOBILE_NUMBER_PATTERN="(0/91)?[7-9][0-9]{9}";
    private static final String Email_PATTERN="^[a-zA-Z0-9]+([+_.-][a-zA-Z0-9]+)*[@][a-zA-Z0-9]+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?";
    private static final String PASSWORD_RULE1_PATTERN="^(?=\\S+$).{8,}$";
    private static final String PASSWORD_RULE2_PATTERN="(?=.*[A-Z])";
    private static final String PASSWORD_RULE3_PATTERN="(?=.*[0-9])";
    private static final String PASSWORD_RULE4_PATTERN="^(?=.*[@#$%^&+=])$";

    public boolean validateFirstName(String fname){
        Pattern pattern = Pattern.compile(FIRST_NAME_PATTERN);
        return pattern.matcher(fname).matches();
    }

    public boolean validateLastName(String lname){
        Pattern pattern = Pattern.compile(LAST_NAME_PATTERN);
        return pattern.matcher(lname).matches();
    }

    public boolean validateMobileNumber(String num){
        Pattern pattern = Pattern.compile(MOBILE_NUMBER_PATTERN);
        return pattern.matcher(num).matches();
    }

    public boolean validateEmailAddress(String email){
        Pattern pattern = Pattern.compile(Email_PATTERN);
        return pattern.matcher(email).matches();
    }

    public boolean validatePasswordRule1(String passwordrule1){
        Pattern pattern = Pattern.compile(PASSWORD_RULE1_PATTERN);
        return pattern.matcher(passwordrule1).matches();
    }

    public boolean validatePasswordRule2(String passwordrule2){
        Pattern pattern = Pattern.compile(PASSWORD_RULE2_PATTERN);
        return pattern.matcher(passwordrule2).matches();
    }

    public boolean validatePasswordRule3(String passwordrule3){
        Pattern pattern = Pattern.compile(PASSWORD_RULE3_PATTERN);
        return pattern.matcher(passwordrule3).matches();
    }

    public boolean validatePasswordRule4(String passwordrule4){
        Pattern pattern = Pattern.compile(PASSWORD_RULE4_PATTERN);
        return pattern.matcher(passwordrule4).matches();
    }
}
