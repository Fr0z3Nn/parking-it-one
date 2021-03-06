package ru.project.parking.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.project.parking.handler.exception.CustomException;
import ru.project.parking.handler.response.Response;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler() {
        super();
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Response> handleException(CustomException e) {
        return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
