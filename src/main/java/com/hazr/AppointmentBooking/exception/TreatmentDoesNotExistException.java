package com.hazr.AppointmentBooking.exception;

public class TreatmentDoesNotExistException extends RuntimeException {
    public TreatmentDoesNotExistException(String message) {
        super(message);
    }
}
