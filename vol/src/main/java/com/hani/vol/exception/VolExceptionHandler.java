package com.hani.vol.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class VolExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(VolNotFoundException.class)
    public Map<String,String> VolNotFoundException(VolNotFoundException e){
        Map<String,String> erreur = new HashMap<>();
        erreur.put("erreur : ", e.getMessage());
        return erreur;
    }


}
