package com.hazr.AppointmentBooking.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

public class RestResponseBuilder {

    private int status;
    private String error;
    private String message;
    private String path;

    public RestResponseBuilder status(int status) {
        this.status = status;
        return this;
    }

    public RestResponseBuilder status(HttpStatus status) {
        this.status = status.value();

        if (status.isError()) {
            this.error = status.getReasonPhrase();
        }

        return this;
    }

    public RestResponseBuilder error(String error) {
        this.error = error;
        return this;
    }

    public RestResponseBuilder exception(ResponseStatusException exception) {
        HttpStatusCode status = exception.getStatusCode();
        this.status = status.value();

        if (!Objects.requireNonNull(exception.getReason()).isBlank()) {
            this.message = exception.getReason();
        }


        if (status.isError()) {
            this.error = exception.getReason();
        }

        return this;
    }

    public RestResponseBuilder message(String message) {
        this.message = message;
        return this;
    }

    public RestResponseBuilder path(String path) {
        this.path = path;
        return this;
    }

    public RestResponse build() {
        RestResponse response = new RestResponse();
        response.setStatus(status);
        response.setError(error);
        response.setMessage(message);
        response.setPath(path);
        return response;
    }

    public ResponseEntity<RestResponse> entity() {
        return ResponseEntity.status(status).headers(HttpHeaders.EMPTY).body(build());
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public String json() {
        return String.format(
                "{\"status\":%d,\"error\":\"%s\",\"message\":\"%s\",\"path\":\"%s\"}",
                status, error, message, path
        );
    }
}