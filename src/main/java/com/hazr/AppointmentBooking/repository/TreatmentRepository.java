package com.hazr.AppointmentBooking.repository;

import com.hazr.AppointmentBooking.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

    public List<Treatment> findAllByArchivedIsFalse();
}
