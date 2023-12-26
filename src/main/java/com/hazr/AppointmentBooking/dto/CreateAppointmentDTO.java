package com.hazr.AppointmentBooking.dto;

import com.hazr.AppointmentBooking.model.Client;
import com.hazr.AppointmentBooking.model.Treatment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CreateAppointmentDTO {

    private LocalDate appDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private Client client;

    private Double totalPrice;

    private List<Treatment> treatments;

    public CreateAppointmentDTO(LocalDate appDate, LocalTime startTime, LocalTime endTime, Client client, Double totalPrice, List<Treatment> treatments) {
        this.appDate = appDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.client = client;
        this.totalPrice = totalPrice;
        this.treatments = treatments;
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

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
}
