package com.hazr.AppointmentBooking.exception;

public class ClientDoesNotExistException extends RuntimeException {
    public ClientDoesNotExistException(String message) {
        super(message);
    }
}
