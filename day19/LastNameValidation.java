package com.day19;
import java.util.regex.*;

public class LastNameValidation {
    public static boolean isValidLastName(String str)
    {

        Pattern ptrn = Pattern.compile("^[A-Z]{1}[a-z]{2,}$");
        Matcher match = ptrn.matcher(str);
        return (match.find() && match.group().equals(str));
    }
    public static void main(String args[])
    {
        String str = "An";
        if (isValidLastName(str))
            System.out.println("It is a valid Last Name.");
        else
            System.out.println("Entered LastName Is Invalid.");
    }
}
