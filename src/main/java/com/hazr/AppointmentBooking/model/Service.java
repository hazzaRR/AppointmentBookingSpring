package com.hazr.AppointmentBooking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serviceName", length = 40)
    private String serviceName;

    @Column(precision = 6, scale = 2)
    private Double price;

    @Column(name = "durationMinutes")
    private Integer durationMinutes;

    protected Service() {
    }

    public Service(Long id, String serviceName, Double price, Integer durationMinutes) {
        this.id = id;
        this.serviceName = serviceName;
        this.price = price;
        this.durationMinutes = durationMinutes;
    }

    public Service(String serviceName, Double price, Integer durationMinutes) {
        this.serviceName = serviceName;
        this.price = price;
        this.durationMinutes = durationMinutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
