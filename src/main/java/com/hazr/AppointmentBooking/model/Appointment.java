package com.hazr.AppointmentBooking.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "appDate")
    private LocalDate appDate;

    @Column(name = "startTime")
    private LocalTime startTime;

    @Column(name = "endTime")
    private LocalTime endTime;

    @OneToOne
    @JoinColumn(name = "clientID", nullable = false)
    private Client client;

    @Column(name = "TotalPrice", precision = 6, scale = 2, columnDefinition = "DEFAULT 0")
    private Double totalPrice;

    protected Appointment() {
    }

    public Appointment(Long id, LocalDate appDate, LocalTime startTime, LocalTime endTime, Client client, Double totalPrice) {
        this.id = id;
        this.appDate = appDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.client = client;
        this.totalPrice = totalPrice;
    }

    public Appointment(LocalDate appDate, LocalTime startTime, LocalTime endTime, Client client, Double totalPrice) {
        this.appDate = appDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.client = client;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
