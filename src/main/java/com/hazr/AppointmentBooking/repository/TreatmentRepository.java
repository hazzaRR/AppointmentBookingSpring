package com.hazr.AppointmentBooking.repository;

import com.hazr.AppointmentBooking.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
