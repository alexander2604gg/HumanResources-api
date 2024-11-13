package com.alexandersaul.rrhh_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class InvalidRenewalException extends RuntimeException{
    public InvalidRenewalException(String message) {
        super(message);
    }
}
