package com.day21;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class UserRegistrationformTest
{
    User_Registration_Form form=new User_Registration_Form();
    User user1=new User("Aniket","Agrawal","Ani1312@gmail.com","9756995816","aNik@1312");
    User user2=new User("aniket","agrawal","Ani1312@gmail.com","9826a889426","an!ke@1312");
    User user3=new User("ani1312","agrawal374","Ani.agr1312@.gmail.com","an759866486814","axyz156");

    @Test
    public void tset_forValidFirstName_True() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_firstName(user1);
        assertTrue(isValid);
    }

    @Test
    public void tset_forValidFirstName_false() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_firstName(user2);
        assertFalse(isValid);
    }

    @Test
    public void tset_forValidFirstName_false_return() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_firstName(user3);
        assertFalse(isValid);
    }

    @Test
    public void tset_forValidLastName_True() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_lastName(user1);
        assertTrue(isValid);
    }

    @Test
    public void tset_forValidLasttName_false() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_lastName(user2);
        assertFalse(isValid);
    }

    @Test
    public void tset_forValidLasttName_false_return() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_lastName(user3);
        assertFalse(isValid);
    }

    @Test
    public void tset_forValidEmailId_True() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_emailId(user1);
        assertTrue(isValid);
    }

    @Test
    public void tset_forValidEmailId_false() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_emailId(user2);
        assertFalse(isValid);
    }

    @Test
    public void tset_forValidEmail_false_return() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_emailId(user3);
        assertFalse(isValid);
    }

    @Test
    public void tset_forValidMobileNumber_True() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_MobileNumber(user1);
        assertTrue(isValid);
    }

    @Test
    public void tset_forValidMobileNumber_false() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_MobileNumber(user2);
        assertFalse(isValid);
    }

    @Test
    public void tset_forValidMobileNumber_false_return() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_MobileNumber(user3);
        assertFalse(isValid);
    }

    @Test
    public void tset_forValidPassword_True() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_Password(user1);
        assertTrue(isValid);
    }

    @Test
    public void tset_forValidPassword_false() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_Password(user2);
        assertFalse(isValid);
    }

    @Test
    public void tset_forValidPassword_false_return() throws UserValidation_Exception
    {
        boolean isValid =form.isValid_Password(user3);
        assertFalse(isValid);
    }

}