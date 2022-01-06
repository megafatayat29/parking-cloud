package com.pascal.parkiraja.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenToParkHere extends RuntimeException{
    public ForbiddenToParkHere(String message) {
        super(message);
    }
}
