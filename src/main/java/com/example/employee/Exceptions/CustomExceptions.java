package com.example.employee.Exceptions;

public class CustomExceptions extends Exception {

    CustomExceptions() {

    }

    public CustomExceptions(String message) {
        super(message);
    }

    CustomExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
