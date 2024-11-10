package com.Erkena.Exceptions;

import org.springframework.http.HttpStatus;

public class UserExceptions {


    private final String messages;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public String getMessages() {
        return messages;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public UserExceptions(String messages, Throwable throwable, HttpStatus httpStatus) {
        this.messages = messages;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }
}
