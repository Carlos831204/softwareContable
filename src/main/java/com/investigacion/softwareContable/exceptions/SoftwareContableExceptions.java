package com.investigacion.softwareContable.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class SoftwareContableExceptions extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public SoftwareContableExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
