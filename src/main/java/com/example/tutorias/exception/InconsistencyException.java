package com.example.tutorias.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InconsistencyException extends RuntimeException {

    private static final long serialVersionUID = 7509740595618586822L;

    public InconsistencyException(String message) {
        super(message);
    }

}
