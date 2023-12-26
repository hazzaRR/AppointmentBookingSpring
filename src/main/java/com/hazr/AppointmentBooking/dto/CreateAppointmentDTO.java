package com.hazr.AppointmentBooking.dto;

import com.hazr.AppointmentBooking.model.Client;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateAppointmentDTO {

    private LocalDate appDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private Client client;

    private Double totalPrice;

    public CreateAppointmentDTO(LocalDate appDate, LocalTime startTime, LocalTime endTime, Client client, Double totalPrice) {
        this.appDate = appDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.client = client;
        this.totalPrice = totalPrice;
    }

    public LocalDate getAppDate() {
        return appDate;
    }

    public void setAppDate(LocalDate appDate) {
        this.appDate = appDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
