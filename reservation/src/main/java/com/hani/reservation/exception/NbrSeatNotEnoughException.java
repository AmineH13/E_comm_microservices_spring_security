package com.hani.reservation.exception;

public class NbrSeatNotEnoughException extends  RuntimeException{
    public NbrSeatNotEnoughException(String message) {
        super(message);
    }
}
