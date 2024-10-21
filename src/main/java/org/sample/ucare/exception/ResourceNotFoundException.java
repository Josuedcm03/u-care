package org.sample.ucare.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException {

    public ResourceNotFoundException(String message) {
        super();
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super();
    }
}