package com.hazr.AppointmentBooking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "treatmentName", length = 40)
    private String treatmentName;

    @Column(name = "price")
    private Double price;

    @Column(name = "durationMinutes")
    private Integer durationMinutes;

    protected Treatment() {
    }

    public Treatment(Long id, String treatmentName, Double price, Integer durationMinutes) {
        this.id = id;
        this.treatmentName = treatmentName;
        this.price = price;
        this.durationMinutes = durationMinutes;
    }

    public Treatment(String treatmentName, Double price, Integer durationMinutes) {
        this.treatmentName = treatmentName;
        this.price = price;
        this.durationMinutes = durationMinutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String serviceName) {
        this.treatmentName = serviceName;
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
