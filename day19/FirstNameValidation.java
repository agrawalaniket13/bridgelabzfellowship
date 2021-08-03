package com.day19;
import java.util.regex.*;

public class FirstNameValidation {
    public static boolean isValidFirstName(String str)
    {

        Pattern ptrn = Pattern.compile("^[A-Z]{1}[a-z]{2,}$");
        Matcher match = ptrn.matcher(str);
        return (match.find() && match.group().equals(str));
    }
    public static void main(String args[])
    {
        String str = "An";
        if (isValidFirstName(str))
            System.out.println("It is a valid First Name.");
        else
            System.out.println("Entered Name Is Invalid.");
    }
}
