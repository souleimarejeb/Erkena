package com.Erkena.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
}
