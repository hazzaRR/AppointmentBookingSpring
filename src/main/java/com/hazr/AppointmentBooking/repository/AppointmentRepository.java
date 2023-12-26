package com.hazr.AppointmentBooking.repository;

import com.hazr.AppointmentBooking.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
