package com.hazr.AppointmentBooking.service;

import com.hazr.AppointmentBooking.dto.CreateAppointmentDTO;
import com.hazr.AppointmentBooking.exception.AppointmentDoesNotExistException;
import com.hazr.AppointmentBooking.model.Appointment;
import com.hazr.AppointmentBooking.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

        Appointment appointment = new Appointment(createAppointmentDTO.getAppDate(), createAppointmentDTO.getStartTime(), createAppointmentDTO.getEndTime(), createAppointmentDTO.getClient(), createAppointmentDTO.getTotalPrice(), "upcoming", null);
        appointmentRepository.save(appointment);
    }

    public void deleteAppointment(long id) {
        appointmentRepository.delete(this.fetchAppointment(id));
    }
}
