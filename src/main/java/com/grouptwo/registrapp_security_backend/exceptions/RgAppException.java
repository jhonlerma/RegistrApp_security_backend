package com.grouptwo.registrapp_security_backend.exceptions;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RgAppException extends RuntimeException{
    
    private int statusCode;
    private String message;
    private Date transactionDate;

    public RgAppException(int statusCode, String message, Date transactionDate){
        
        super();
        this.statusCode = statusCode;
        this.message = message;
        this.transactionDate = transactionDate;
    }
}
