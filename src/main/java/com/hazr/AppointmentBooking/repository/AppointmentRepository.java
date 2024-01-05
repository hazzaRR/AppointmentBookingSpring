package com.hazr.AppointmentBooking.repository;

import com.hazr.AppointmentBooking.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    public List<Appointment> findAppointmentByAppDateAfterAndAppDateBeforeAndStatusEqualsIgnoreCase(LocalDate startTime, LocalDate endTime, String status);

    public List<Appointment> findAppointmentByAppDateAfterAndAppDateBeforeAndStatusEqualsIgnoreCaseAndPaymentTypeEqualsIgnoreCase(LocalDate startDate, LocalDate endDate, String status, String paymentType);
}
