package com.day9;
import java.util.*;

class Contact {
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;


    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getfirstName() {
        return firstName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    public String getlastName() {
        return lastName;
    }

    public void setcity(String city) {
        this.city = city;
    }
    public String getcity() {
        return city;
    }

    public void setstate(String state) {
        this.state = state;
    }
    public String getstate() {
        return state;
    }

    public void setzip(String zip) {
        this.zip = zip;
    }
    public String getzip() {
        return zip;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setemail(String email) {
        this.email = email;
    }
    public String getemail() {
        return email;
    }

    @Override
    public String toString() {
        return '\n'+"Contact is"+'\n'+ "First Name: " + firstName +'\n'+ "Last  Name: " + lastName +'\n'+ "City : " + city +'\n'+ "State : " + state
                + "zip : " + zip +'\n'+"Phone Number : " + phoneNumber +'\n'+ "Email Id: " + email +'\n';
    }


    public void Add_Contact() {
        Scanner s=new Scanner(System.in);
        System.out.print("Add Contact  \n");
        System.out.print("Enter First Name: ");
        this.firstName=s.nextLine();
        System.out.print("Enter Last Name : ");
        this.lastName=s.nextLine();
        System.out.print("Enter City : ");
        this.city=s.nextLine();
        System.out.print("Enter State : ");
        this.state=s.nextLine();
        System.out.print("Enter zip : ");
        this.zip=s.nextLine();
        System.out.print("Enter PhoneNumber: ");
        this.phoneNumber=s.nextLine();
        System.out.print("Enter Email ID : ");
        this.email=s.nextLine();
    }

    public void Display_All(ArrayList<Contact> arr){
        boolean is_Empty=arr.isEmpty();
        if(is_Empty==true)
            System.out.println("Array List is Empty");
        else
            System.out.println(arr);
    }
}

public class AddressBook {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        ArrayList<Contact> list=new ArrayList<Contact>();
        int option;
        do
        {
            Contact c=new Contact();
            System.out.println("Enter your option : ");
            System.out.println("1.Add contact  ");
            System.out.println("2.Display all contact ");

            option=s.nextInt();

            switch (option)
            {
                case 1:
                    c.Add_Contact();
                    list.add(c);
                    break;
                case 2:
                    c.Display_All(list);
                    break;
                default:
                    System.out.println("Enter valid option");
                    break;
            }
            System.out.println("Do you want to continue (1.Continue\0.Exit)");
            option=s.nextInt();
        }
        while (option!=0);
    }
}