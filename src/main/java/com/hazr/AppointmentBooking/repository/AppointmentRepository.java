package com.hazr.AppointmentBooking.repository;

import com.hazr.AppointmentBooking.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    public List<Appointment> findAppointmentByAppDateGreaterThanEqualAndAppDateLessThanEqualAndStatusEqualsIgnoreCase(LocalDate startTime, LocalDate endTime, String status);
    public List<Appointment> findAppointmentByAppDateGreaterThanEqualAndAppDateLessThanEqualAndStatusEqualsIgnoreCaseAndPaymentTypeEqualsIgnoreCase(LocalDate startDate, LocalDate endDate, String status, String paymentType);
}
