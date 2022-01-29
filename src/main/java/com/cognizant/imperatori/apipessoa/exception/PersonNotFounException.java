package com.cognizant.imperatori.apipessoa.exception;

public class PersonNotFounException extends Exception {

    public PersonNotFounException(Long id){
        super("Person not found with Id: " + id);
    }
}
