package com.hazr.AppointmentBooking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "appointmentService")
public class AppointmentService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "appointmentID")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "serviceID")
    private Service service;

    public AppointmentService() {
    }

    public AppointmentService(Long id, Appointment appointment, Service service) {
        this.id = id;
        this.appointment = appointment;
        this.service = service;
    }

    public AppointmentService(Appointment appointment, Service service) {
        this.appointment = appointment;
        this.service = service;
    }
}
