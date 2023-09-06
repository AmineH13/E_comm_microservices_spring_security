package com.hani.reservation.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ReservationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NbrSeatNotEnoughException.class)
    public Map<String,String> NbrSeatNotEnoughException(NbrSeatNotEnoughException e){
        Map<String,String> erreur = new HashMap<>();
        erreur.put("erreur : ", e.getMessage());
        return erreur;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(VolNotFoundException.class)
    public Map<String,String> VolNotFoundException(VolNotFoundException e){
        Map<String,String> erreur = new HashMap<>();
        erreur.put("erreur : ", e.getMessage());
        return erreur;
    }

}
