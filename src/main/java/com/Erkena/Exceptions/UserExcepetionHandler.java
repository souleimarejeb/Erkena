package com.Erkena.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserExcepetionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException
            (NotFoundException userNotFoundException)
    {
                UserExceptions userException = new UserExceptions(
                        userNotFoundException.getMessage(),
                        userNotFoundException.getCause(),
                        HttpStatus.NOT_FOUND
    );
                return new ResponseEntity<>(userException,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {UserAlreadyExistsException.class})
    public ResponseEntity<Object> handleFoundException
            (UserAlreadyExistsException userAlreadyExistsException)
    {
        UserExceptions userException = new UserExceptions(
                userAlreadyExistsException.getMessage(),
                userAlreadyExistsException.getCause(),
                HttpStatus.FOUND
        );
        return new ResponseEntity<>(userException,HttpStatus.FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Iterate over the field errors and extract the field name and error message
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        // Return a response with a map of validation errors and 400 status code
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
