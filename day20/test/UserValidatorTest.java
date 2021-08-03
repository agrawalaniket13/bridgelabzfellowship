package com.day201;

import org.junit.Test;
import org.testng.Assert;

public class UserValidatorTest {
    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue(){
        UserValidator validator = new UserValidator();
        boolean result = validator.validateFirstName("Aniket");
        Assert.assertTrue(result);
    }

    @Test
    public void givenFirstName_WhenShort_ShouldReturnFalse(){
        UserValidator validator = new UserValidator();
        boolean result = validator.validateFirstName("An");
        Assert.assertTrue(result);
    }

    @Test
    public void givenFirstName_WhenwithSpChars_ShouldReturnFalse(){
        UserValidator validator = new UserValidator();
        boolean result = validator.validateFirstName("An@agr");
        Assert.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenProper_ShouldReturnTrue(){
        UserValidator validator = new UserValidator();
        boolean result = validator.validateLastName("Agrawal");
        Assert.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenNotProper_ShouldReturnFalse(){
        UserValidator validator = new UserValidator();
        boolean result = validator.validateLastName("Ag");
        Assert.assertFalse(result);
    }

    @Test
    public void givenMobileNumber_WhenProper_ShouldReturnTrue(){
        UserValidator validator = new UserValidator();
        boolean result = validator.validateMobileNumber("9826887515");
        Assert.assertTrue(result);
    }

    @Test
    public void givenMobileNumber_WhenNotProper_ShouldReturnFalse(){
        UserValidator validator = new UserValidator();
        boolean result = validator.validateMobileNumber("98");
        Assert.assertFalse(result);
    }

    @Test
    public void givenEmail_WhenValid_ShouldReturnTrue(){
        UserValidator validator = new UserValidator();
        boolean result = validator.validateEmailAddress("ani@xyz.com");
        Assert.assertTrue(result);
    }
}
