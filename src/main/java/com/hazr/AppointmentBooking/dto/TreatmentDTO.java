package com.hazr.AppointmentBooking.dto;

public class TreatmentDTO {

    private String treatmentName;

    private Double price;

    private Integer durationMinutes;

    public TreatmentDTO(String treatmentName, Double price, Integer durationMinutes) {
        this.treatmentName = treatmentName;
        this.price = price;
        this.durationMinutes = durationMinutes;
    }


    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
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
