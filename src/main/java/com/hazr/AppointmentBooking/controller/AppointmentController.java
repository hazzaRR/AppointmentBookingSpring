package com.hazr.AppointmentBooking.controller;

import com.hazr.AppointmentBooking.dto.CreateAppointmentDTO;
import com.hazr.AppointmentBooking.dto.TreatmentDTO;
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
    }    @GetMapping("/appointment-between")
    public List<Appointment> getAllAppointmentsBetweenRange(@RequestParam(value = "start") String startDate, @RequestParam(value = "end") String endDate) {
        return appointmentService.fetchAllAppointmentsBetweenRange(startDate, endDate);
    }

    @GetMapping("/appointmentId/{id}")
    public Appointment getAppointment(@PathVariable long id) {
        return appointmentService.fetchAppointmentById(id);
    }

    @GetMapping("/summary-report")
    public List<Appointment> getSummaryReport(@RequestParam(value = "start") String startDate, @RequestParam(value = "end") String endDate, @RequestParam(value = "payment", required = false) String paymentType) {
        return appointmentService.fetchSummaryReport(startDate, endDate, paymentType);

    }

    @PostMapping("/")
    public void createAppointment(@RequestBody CreateAppointmentDTO createAppointmentDTO) {
        appointmentService.createAppointment(createAppointmentDTO);
    }

    @DeleteMapping("/appointmentId/{id}")
    public void createAppointment(@PathVariable long id) {
        appointmentService.deleteAppointment(id);
    }

    @PutMapping("/outcome/{id}")
    public void updateAppointmentOutcome(@PathVariable long id, @RequestParam(value = "status", required = true) String status, @RequestParam(value = "payment", required = false) String paymentType) {
        appointmentService.updateOutcome(id, status, paymentType);
    }

    @PutMapping("/appointmentId/{id}")
    public void updateAppointment(@PathVariable long id, @RequestBody Appointment appointment) {
        appointmentService.updateAppointment(id, appointment);
    }
}
