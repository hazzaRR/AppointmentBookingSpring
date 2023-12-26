package com.hazr.AppointmentBooking.model;

import jakarta.persistence.*;

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
    @JoinColumn(name = "clientid", nullable = false)
    private Client client;

    @Column(name = "TotalPrice")
    private Double totalPrice;


    @Column(name = "status")
    private String status;
    @Column(name = "paymentType")
    private String paymentType;

    @ManyToMany
    @JoinTable(
            name = "appointment_treatment",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "treatment_id")
    )

    private List<Treatment> treatments;

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appDate=" + appDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", client=" + client +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", treatments=" + treatments +
                '}';
    }

    protected Appointment() {
    }


    public Appointment(Long id, LocalDate appDate, LocalTime startTime, LocalTime endTime, Client client, Double totalPrice, String status, String paymentType, List<Treatment> treatments) {
        this.id = id;
        this.appDate = appDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.client = client;
        this.totalPrice = totalPrice;
        this.status = status;
        this.paymentType = paymentType;
        this.treatments = treatments;
    }

    public Appointment(LocalDate appDate, LocalTime startTime, LocalTime endTime, Client client, Double totalPrice, String status, String paymentType, List<Treatment> treatments) {
        this.appDate = appDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.client = client;
        this.totalPrice = totalPrice;
        this.status = status;
        this.paymentType = paymentType;
        this.treatments = treatments;
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

    public List<Treatment> getServices() {
        return treatments;
    }

    public void setServices(List<Treatment> treatments) {
        this.treatments = treatments;
    }
}
