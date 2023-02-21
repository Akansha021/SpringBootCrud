package com.example.springbootcrud.exceptioncontroller;

import com.example.springbootcrud.customexceptionclass.CustomProductExceptionHandler;
import com.example.springbootcrud.customexceptionclass.ProductException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CustomProductExceptionHandler.class)
    public ResponseEntity<Object> handleException(CustomProductExceptionHandler customProductExceptionHandler){
        HttpStatus request=HttpStatus.NOT_FOUND;
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("val","headerval");
        CustomProductExceptionHandler c=new CustomProductExceptionHandler(customProductExceptionHandler.getMssg(),request, ZonedDateTime.now(ZoneId.of("Z")));

/*
        It can also be done in this way.
        return ResponseEntity.status(request).headers(httpHeaders).body(customProductExceptionHandler);
        return new ResponseEntity<>(c,request);

 */
        return ResponseEntity.status(request).headers(httpHeaders).body(c);
    }
    @ExceptionHandler(value= NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String exceptionHandlerNull(Model m) {
        m.addAttribute("msg","Null Pointer Exception");
        return "Page is invalid";
    }



/*


    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<String> handleCustomException() {
       NullPointerException exception=new NullPointerException("NULL");
       CustomProductExceptionHandler customProductExceptionHandler=new CustomProductExceptionHandler("NULLL");
       return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
               ResponseEntity
               .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(customProductExceptionHandler.getMessage());
    }

 */
}
