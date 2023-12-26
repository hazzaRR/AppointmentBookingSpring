package com.hazr.AppointmentBooking.controller;

import com.hazr.AppointmentBooking.dto.CreateAppointmentDTO;
import com.hazr.AppointmentBooking.model.Appointment;
import com.hazr.AppointmentBooking.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {



    private final AppointmentService appointmentService;


    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @GetMapping("/")
    public List<Appointment> getAllAppointments() {
        return appointmentService.fetchAllAppointments();
    }

    @GetMapping("/postId/{id}")
    public Appointment getAppointment(@PathVariable long id) {
        return appointmentService.fetchAppointmentById(id);
    }

    @PostMapping("/")
    public void createAppointment(@RequestBody CreateAppointmentDTO createAppointmentDTO) {
        appointmentService.createAppointment(createAppointmentDTO);
    }

    @DeleteMapping("/postId/{id}")
    public void createAppointment(@PathVariable long id) {
        appointmentService.deleteAppointment(id);
    }
}
