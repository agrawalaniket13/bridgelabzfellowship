package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class  User_Registration_Form
{
    static Pattern p;
    static Matcher m;
    static String regex;

    protected static boolean isValid_firstName(User user) throws UserValidation_Exception{
        regex="^[A-Z]{1}[a-z]+";
        p = Pattern.compile(regex);
        try {
            if (user.getFirstName() == null) {
                throw new UserValidation_Exception(UserValidation_Exception.Validation.NULL,"Null firstName");
            }
            else if(user.getFirstName()==" ")
                throw new UserValidation_Exception(UserValidation_Exception.Validation.EMPTY,"Empty firstName");
            else {
                m= p.matcher(user.getFirstName());
                return m.matches();
            }
        }catch(Exception e) {
            throw new UserValidation_Exception(UserValidation_Exception.Validation.INVALID,"Invalid firstName");
        }

    }

    protected boolean isValid_lastName(User user) throws UserValidation_Exception{
        regex="^[A-Z]{1}[a-z]+";
        p = Pattern.compile(regex);
        try {
            if (user.getLastName()== null)
                throw new UserValidation_Exception(UserValidation_Exception.Validation.NULL,"Null lastName");
            else if(user.getLastName()==" ")
                throw new UserValidation_Exception(UserValidation_Exception.Validation.EMPTY,"Empty lasttName");
            else {
                m= p.matcher(user.getLastName());
                return m.matches();
            }
        }catch(Exception e) {
            throw new UserValidation_Exception(UserValidation_Exception.Validation.INVALID,"Invalid firstName");
        }
    }

    protected boolean isValid_emailId(User user) throws UserValidation_Exception{
        regex="^[A-Z a-z 0-9]+([._+-][0-9 a-z A-Z]+)*@[0-9 a-z A-Z]+.[a-z A-Z]{2,3}([.][a-z A-Z]{2})*$";
        p = Pattern.compile(regex);
        try {
            if (user.getEmailId() == null)
                throw new UserValidation_Exception(UserValidation_Exception.Validation.NULL,"Null Email Id");
            else if(user.getEmailId()==" ")
                throw new UserValidation_Exception(UserValidation_Exception.Validation.EMPTY,"Empty Email Id");
            else {
                m= p.matcher(user.getEmailId());
                return m.matches();
            }
        }catch(Exception e) {
            throw new UserValidation_Exception(UserValidation_Exception.Validation.INVALID,"Invalid Email Id");
        }
    }

    protected boolean isValid_MobileNumber(User user) throws UserValidation_Exception{
        regex="^[1-9]{2}\\s{0,1}[1-9]{1}[0-9]{9}$";
        p = Pattern.compile(regex);
        try {
            if (user.getMobileNumber()== null)
                throw new UserValidation_Exception(UserValidation_Exception.Validation.NULL,"Null Mobile Number");
            else if(user.getMobileNumber()==" ")
                throw new UserValidation_Exception(UserValidation_Exception.Validation.EMPTY,"Empty Mobile Number");
            else {
                m= p.matcher(user.getMobileNumber());
                return m.matches();
            }
        }catch(Exception e) {
            throw new UserValidation_Exception(UserValidation_Exception.Validation.INVALID,"Invalid Mobile Number");
        }
    }

    protected boolean isValid_Password(User user) throws UserValidation_Exception{
        regex="^(?=[0-9 A-Z a-z !@#$%^&*();:]{8,}$)(?=.*?[A-Z]{1,})(?=.*?[0-9]{1,})(?=.*?[!@#$%^&*();:]{1,}).*$";
        p = Pattern.compile(regex);
        try {
            if (user.getPassword()== null)
                throw new UserValidation_Exception(UserValidation_Exception.Validation.NULL,"Null Password");
            else if(user.getPassword()==" ")
                throw new UserValidation_Exception(UserValidation_Exception.Validation.EMPTY,"Empty Password");
            else {
                m= p.matcher(user.getPassword());
                return m.matches();
            }
        }catch(Exception e) {
            throw new UserValidation_Exception(UserValidation_Exception.Validation.INVALID,"Invalid Password");
        }
    }

    public static void main(String[] args) throws UserValidation_Exception
    {
        Scanner sc=new Scanner(System.in);
        User_Registration_Form form=new User_Registration_Form();
        User user=new User("Rohit","Dighe","rohit123@gmail.com","778899665544","awqe@123");

        while(true){
            System.out.println("Enter First Name");
            user.setFirstName(sc.nextLine());
            if((form.isValid_firstName(user))==true)
                break;
            else
                System.out.println("Invalid...1st letter must be Capital");
        }

        while(true){
            System.out.println("Enter last Name");
            user.setLastName(sc.nextLine());
            if((form.isValid_lastName(user))==true)
                break;
            else
                System.out.println("Invalid...1st letter must be Capital");
        }

        while(true){
            System.out.println("Enter Email Id");
            user.setEmailId(sc.nextLine());
            if((form.isValid_emailId(user))==true)
                break;
            else
                System.out.println("Invalid.. enter valid email Id");
        }

        while(true){
            System.out.println("Enter Mobile Number");
            user.setMobileNumber(sc.nextLine());
            if((form.isValid_MobileNumber(user))==true)
                break;
            else
                System.out.println("Invalid.. enter 10 digit mobile number with 2 digit code");
        }

        while(true){
            System.out.println("Enter Password");
            user.setPassword(sc.nextLine());
            if((form.isValid_Password(user))==true)
                break;
            else
                System.out.println("Invalid.. enter 8 char min with 1 capital letter and at 1 digit");
        }
    }
}

class User
{
    private String firstName;
    private String lastName;
    private String emailId;
    private String mobileNumber;
    private String password;

    public User(String firstName,String lastName,String emailId,String mobileNumber,String password) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.emailId=emailId;
        this.mobileNumber=mobileNumber;
        this.password=password;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstname) {
        this.firstName=firstname;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public String getEmailId(){
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId=emailId;;
    }

    public String getMobileNumber(){
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber=mobileNumber;;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password) {
        this.password=password;
    }
}