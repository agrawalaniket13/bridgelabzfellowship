package com.day23;

import java.util.Scanner;
import java.util.regex.Pattern;

@FunctionalInterface
interface UserRegistrationInterface {
    void userCheck();
}

public class UserRegistrationLambdaExpression {
    public static void main(String[] args) {
        UserRegistrationInterface obj ;
        obj= ()-> {
            System.out.println("Welcome to User Registration");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter first Name : ");
            String firstName = scanner.next();
            System.out.println(Pattern.matches("[A-Z][a-z]{2,}", firstName));

            System.out.println("Enter last Name : ");
            String lastName = scanner.next();
            System.out.println(Pattern.matches("[A-Z][a-z]{2,}", lastName));

            System.out.println("Enter email : ");
            String email = scanner.next();
            System.out.println(Pattern.matches("^[a-zA-Z0-9]+([+_.-][a-zA-Z0-9]+)*[@][a-zA-Z0-9]+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})$", email));

            System.out.println("Enter phone number: ");
            String phoneNum = scanner.next();
            System.out.println(Pattern.matches("^(0/91)?[7-9][0-9]{9}$", phoneNum));

            System.out.println("Enter password : ");
            String password = scanner.next();
            System.out.println(Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=[^@#$%^&+=]*[@#$%^&+=][^@#$%^&+=]*$)(?=.*[0-9]).{8,}$", password));

        };
        obj.userCheck();
    }
}
