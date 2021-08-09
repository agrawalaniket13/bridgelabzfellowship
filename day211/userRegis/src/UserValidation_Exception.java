package com.day21;
public class UserValidation_Exception extends Exception {

    enum Validation{
        INVALID,NULL,EMPTY;
    }

    private Validation code;

    public UserValidation_Exception(Validation code,String message)  {
        super(message);
        this.code=code;
    }

}
