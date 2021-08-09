package com.day22;

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
}

public class AddressBook {
    static String f_name;
    static ArrayList<Contact> list=new ArrayList<Contact>();
    static Scanner s=new Scanner(System.in);

    public void Add_Contact(Contact c) {
        Scanner s=new Scanner(System.in);
        System.out.print("Add Contact  \n");
        System.out.print("Enter First Name: ");
        c.setfirstName(s.nextLine());
        System.out.print("Enter Last Name : ");
        c.setlastName(s.nextLine());
        System.out.print("Enter City : ");
        c.setcity(s.nextLine());
        System.out.print("Enter State : ");
        c.setstate(s.nextLine());
        System.out.print("Enter zip : ");
        c.setzip(s.nextLine());
        System.out.print("Enter PhoneNumber: ");
        c.setphoneNumber(s.nextLine());
        System.out.print("Enter Email ID : ");
        c.setemail(s.nextLine());
        list.add(c);
    }

    public void Display_All(){
        boolean is_Empty=list.isEmpty();
        if(is_Empty==true)
            System.out.println("Array List is Empty");
        else
            System.out.println(list);
    }

    public void editContact(Contact c, String f_name ) {
        for (int i = 0; i < list.size(); i++) {
            c = (Contact)list.get(i);
            if (f_name.equals(c.getfirstName())) {
                System.out.print("Enter new First Name: ");
                c.setfirstName(s.nextLine());
                System.out.print("Enter  new Last Name : ");
                c.setlastName(s.nextLine());
                System.out.print("Enter new City : ");
                c.setcity(s.nextLine());
                System.out.print("Enter new State : ");
                c.setstate(s.nextLine());
                System.out.print("Enter new zip : ");
                c.setzip(s.nextLine());
                System.out.print("Enter new PhoneNumber: ");
                c.setphoneNumber(s.nextLine());
                System.out.print("Enter new Email ID : ");
                c.setemail(s.nextLine());
                list.set(i,c);
                System.out.println(list);
            }
            else
                System.out.println("Not Found");
        }
    }

    public void deleteContact(Contact c,String f_name){
        for(int i = 0; i < list.size(); i++){
            c = (Contact)list.get(i);
            if(f_name.equals(c.getfirstName())){
                list.remove(i);
            }
        }
    }

    public static void main(String[] args) {

        AddressBook book=new AddressBook();
        Contact c;

        int option;
        do
        {
            System.out.println("Enter your option : ");
            System.out.println("1.Add contact  ");
            System.out.println("2.Display all contact ");
            System.out.println("3.Edit Contact ");
            System.out.println("4.Delete Contact ");

            option=s.nextInt();
            c=new Contact();
            Scanner sc=new Scanner(System.in);

            switch (option)
            {
                case 1:
                    book.Add_Contact(c);
                    break;
                case 2:
                    book.Display_All();
                    break;
                case 3:
                    System.out.println("Enter first name that you want to edit:");
                    f_name=sc.nextLine();
                    book.editContact(c,f_name);
                    break;
                case 4:
                    System.out.println("Enter first name that you want to edit:");
                    f_name=sc.nextLine();
                    book.deleteContact(c,f_name);
                    break;
                default:
                    System.out.println("Enter valid option");
                    break;
            }
            System.out.println("Do you want to continue (1.Continue or 0.Exit)");
            option=s.nextInt();
        }
        while (option!=0);
    }
}
