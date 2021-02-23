package com.sda.company.exception;

//extindem Runtime pt a afecta exceptiile din timpul rularii
public class DepartmentException extends RuntimeException {

    public DepartmentException(String message){
        super(message);
    }


}
