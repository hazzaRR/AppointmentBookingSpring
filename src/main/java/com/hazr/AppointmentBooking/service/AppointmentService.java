package com.hazr.AppointmentBooking.service;

import com.hazr.AppointmentBooking.dto.CreateAppointmentDTO;
import com.hazr.AppointmentBooking.exception.AppointmentDoesNotExistException;
import com.hazr.AppointmentBooking.model.Appointment;
import com.hazr.AppointmentBooking.model.Treatment;
import com.hazr.AppointmentBooking.repository.AppointmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AppointmentService {


    private final AppointmentRepository appointmentRepository;


    public Appointment fetchAppointment(Long id) {

        Optional<Appointment> appointment = appointmentRepository.findById(id);

        if (appointment.isEmpty()) {
            throw new AppointmentDoesNotExistException("The appointment with the id: " + id + " does not exist");
        }

        return appointment.get();
    }


    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> fetchAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment fetchAppointmentById(long id) {
        return fetchAppointment(id);
    }

    public void createAppointment(CreateAppointmentDTO createAppointmentDTO) {

        Appointment appointment = new Appointment(createAppointmentDTO.getAppDate(), createAppointmentDTO.getStartTime(), createAppointmentDTO.getEndTime(), createAppointmentDTO.getClient(), createAppointmentDTO.getTotalPrice(), "upcoming", null, createAppointmentDTO.getTreatments());
        appointmentRepository.save(appointment);
    }

    public void deleteAppointment(long id) {
        appointmentRepository.delete(this.fetchAppointment(id));
    }


    @Transactional
    public void updateOutcome(long id, String status, String paymentType) {

        Appointment appointmentDetails = this.fetchAppointment(id);

        if(status != null && !status.isEmpty() && !Objects.equals(status, appointmentDetails.getStatus())) {
            appointmentDetails.setStatus(status);
        }

        if(paymentType != null && !paymentType.isEmpty() && !Objects.equals(paymentType, appointmentDetails.getPaymentType())) {
            appointmentDetails.setPaymentType(paymentType);
        }

    }

    public List<Appointment> fetchSummaryReport(String startDate, String endDate, String paymentType) {

        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        final LocalDate start = LocalDate.parse(startDate, dtf);
        final LocalDate end = LocalDate.parse(endDate, dtf);

        if(paymentType == null) {
            return appointmentRepository.findAppointmentByAppDateAfterAndAppDateBeforeAndStatusEqualsIgnoreCase(start, end, "completed");
        }

        return appointmentRepository.findAppointmentByAppDateAfterAndAppDateBeforeAndStatusEqualsIgnoreCaseAndPaymentTypeEqualsIgnoreCase(start, end, "completed", paymentType);
    }

    @Transactional
    public void updateAppointment(long id, Appointment appointment) {

        Appointment appointmentDetails = this.fetchAppointment(id);


        if(appointment.getAppDate() != null && !Objects.equals(appointment.getAppDate() , appointmentDetails.getAppDate())) {
            appointmentDetails.setAppDate(appointment.getAppDate());
        }

        if(appointment.getStartTime() != null && !Objects.equals(appointment.getStartTime() , appointmentDetails.getStartTime())) {
            appointmentDetails.setStartTime(appointment.getStartTime());
        }

        if(appointment.getEndTime() != null && !Objects.equals(appointment.getEndTime() , appointmentDetails.getEndTime())) {
            appointmentDetails.setEndTime(appointment.getEndTime());
        }

        if(appointment.getTotalPrice() != null && !Objects.equals(appointment.getTotalPrice() , appointmentDetails.getTotalPrice())) {
            appointmentDetails.setTotalPrice(appointment.getTotalPrice());
        }

        if(appointment.getStatus() != null && !Objects.equals(appointment.getStatus() , appointmentDetails.getStatus())) {
            appointmentDetails.setStatus(appointment.getStatus());
        }

        if(appointment.getPaymentType() != null && !Objects.equals(appointment.getPaymentType() , appointmentDetails.getPaymentType())) {
            appointmentDetails.setPaymentType(appointment.getPaymentType());
        }

        if(appointment.getTreatments() != null && !Objects.equals(appointment.getTreatments() , appointmentDetails.getTreatments())) {
            appointmentDetails.setTreatments(appointment.getTreatments());
        }

    }
}
