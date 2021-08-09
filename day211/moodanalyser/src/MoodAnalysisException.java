package com.day21;

public class MoodAnalysisException extends Exception {

    TypeOfException type;

    // to check whether message is null or empty
    enum TypeOfException {
        ENTERED_NULL,ENTERED_EMPTY;
    }

    public MoodAnalysisException(String message,TypeOfException type) {
        super(message);
        this.type = type;
    }

}