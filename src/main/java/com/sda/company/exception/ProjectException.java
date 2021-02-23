package com.sda.company.exception;

//extindem Runtime pt a afecta exceptiile din timpul rularii
public class ProjectException extends RuntimeException {

    public ProjectException(String message){
        super(message);
    }


}
