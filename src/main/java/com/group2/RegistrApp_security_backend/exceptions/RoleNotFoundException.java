package com.group2.RegistrApp_security_backend.exceptions;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleNotFoundException extends RuntimeException {
    
    private int statusCode;
    private String message;
    private Date transactionDate;

    public RoleNotFoundException(String message, int statuscode, Date transactionDate){

        super();
        this.statusCode = statuscode;
        this.message = message;
        this.transactionDate = transactionDate;
    }
}
