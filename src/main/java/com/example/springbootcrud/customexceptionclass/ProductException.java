package com.example.springbootcrud.customexceptionclass;

public class ProductException extends RuntimeException{
    public ProductException(String msg){
        super(msg);
    }

    ProductException(String msg,Throwable throwable){
        super(msg,throwable);
    }
}
