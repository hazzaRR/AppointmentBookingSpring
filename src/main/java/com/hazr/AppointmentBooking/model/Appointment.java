package com.hazr.AppointmentBooking.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
    @JoinColumn(name = "id", nullable = false)
    private Client client;

    @Column(name = "TotalPrice")
    private Double totalPrice;


    @Column(name = "status")
    private String status;
    @Column(name = "paymentType")
    private String paymentType;

    @ManyToMany
    @JoinTable(
            name = "appointment_service",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )

    private List<Service> services;

    protected Appointment() {
    }


    public Appointment(Long id, LocalDate appDate, LocalTime startTime, LocalTime endTime, Client client, Double totalPrice, String status, String paymentType, List<Service> services) {
        this.id = id;
        this.appDate = appDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.client = client;
        this.totalPrice = totalPrice;
        this.status = status;
        this.paymentType = paymentType;
        this.services = services;
    }

    public Appointment(LocalDate appDate, LocalTime startTime, LocalTime endTime, Client client, Double totalPrice, String status, String paymentType, List<Service> services) {
        this.appDate = appDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.client = client;
        this.totalPrice = totalPrice;
        this.status = status;
        this.paymentType = paymentType;
        this.services = services;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
