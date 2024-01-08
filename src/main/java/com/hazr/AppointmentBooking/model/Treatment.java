package com.hazr.AppointmentBooking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "treatment_name", length = 40)
    private String treatmentName;

    @Column(name = "price")
    private Double price;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(name = "archived")
    private boolean archived;


    @Override
    public String toString() {
        return "Treatment{" +
                "id=" + id +
                ", treatmentName='" + treatmentName + '\'' +
                ", price=" + price +
                ", durationMinutes=" + durationMinutes +
                ", archived=" + archived +
                '}';
    }

    protected Treatment() {
    }

    public Treatment(Long id, String treatmentName, Double price, Integer durationMinutes, boolean archived) {
        this.id = id;
        this.treatmentName = treatmentName;
        this.price = price;
        this.durationMinutes = durationMinutes;
        this.archived = archived;
    }


    public Treatment(String treatmentName, Double price, Integer durationMinutes, boolean archived) {
        this.treatmentName = treatmentName;
        this.price = price;
        this.durationMinutes = durationMinutes;
        this.archived = archived;
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

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
