package com.example.ex1_managementapartmentbuilding.exception;

public class ForeignKeyException extends RuntimeException{
    public ForeignKeyException(String message) {
        super(message);
    }
}
