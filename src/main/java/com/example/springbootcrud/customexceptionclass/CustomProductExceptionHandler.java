package com.example.springbootcrud.customexceptionclass;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;


public class CustomProductExceptionHandler extends RuntimeException {
    private  String mssg;
//    private  Throwable throwable;
    private  HttpStatus httpStatus;
    private  ZonedDateTime zonedDateTime;

//, Throwable throwable
    public CustomProductExceptionHandler(String mssg, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
        this.mssg = mssg;
//        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.zonedDateTime = zonedDateTime;
    }
    public CustomProductExceptionHandler(String mssg){
        this.mssg=mssg;
    }


    public String getMssg() {
        return mssg;
    }

//    public Throwable getThrowable() {
//        return throwable;
//    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    //    public CustomProductExceptionHandler(String message){
//        super(HttpStatus.INTERNAL_SERVER_ERROR, "NULL");
//    }

//    @Override
//    public HttpHeaders getResponseHeaders() {
//        // return response headers
//    }
}
