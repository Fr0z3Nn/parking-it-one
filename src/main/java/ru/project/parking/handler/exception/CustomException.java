package ru.project.parking.handler.exception;

public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
