package com.hazr.AppointmentBooking.exception;

public class AppointmentDoesNotExistException extends RuntimeException {
    public AppointmentDoesNotExistException(String message) {
        super(message);
    }
}
