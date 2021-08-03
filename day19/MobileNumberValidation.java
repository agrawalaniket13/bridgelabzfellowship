package com.day19;
import java.util.regex.*;

public class MobileNumberValidation {
    public static boolean isValidMobileNo(String str)
    {

        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = ptrn.matcher(str);
        return (match.find() && match.group().equals(str));
    }
    public static void main(String args[])
    {
        String str = "98";
        if (isValidMobileNo(str))
            System.out.println("It is a valid mobile number.");
        else
            System.out.println("Entered mobile number is invalid.");
    }
}
