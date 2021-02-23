package com.sda.company.exception;

//extindem Runtime pt a afecta exceptiile din timpul rularii
public class CompanyException extends RuntimeException {

    public CompanyException (String message){
        super(message);
    }


}
