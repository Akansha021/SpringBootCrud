package com.example.springbootcrud.customexceptionclass;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="Id Not Found")
public class IdNotFoundException extends RuntimeException{



    IdNotFoundException(Throwable throwable){
        super(throwable);
    }
    IdNotFoundException(String msg, Throwable throwable){
        super(msg,throwable);
    }
    public IdNotFoundException(String msg){
        super(msg);
    }
}
