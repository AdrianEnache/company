package com.sda.company.exception;

//extindem Runtime pt a afecta exceptiile din timpul rularii
public class EmployeeException extends RuntimeException {

    public EmployeeException(String message){
        super(message);
    }


}
