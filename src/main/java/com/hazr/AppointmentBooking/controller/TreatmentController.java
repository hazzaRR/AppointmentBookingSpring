package com.hazr.AppointmentBooking.controller;

import com.hazr.AppointmentBooking.dto.TreatmentDTO;
import com.hazr.AppointmentBooking.model.Treatment;
import com.hazr.AppointmentBooking.service.TreatmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treatment")
@CrossOrigin(origins = "http://localhost:5173")
public class TreatmentController {


    private final TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }


    @GetMapping("/")
    public List<Treatment> getAllTreatments() {
        return treatmentService.fetchAllTreatments();
    }

    @GetMapping("/treatmentId/{id}")
    public Treatment getTreatmentById(@PathVariable long id) {
        return treatmentService.fetchTreatmentById(id);
    }

    @PostMapping("/")
    public void createTreatment(@RequestBody TreatmentDTO treatmentDTO) {
        treatmentService.createTreatment(treatmentDTO);
    }

    @DeleteMapping("/treatmentId/{id}")
    public void deleteTreatmentById(@PathVariable long id) {
        treatmentService.deleteTreatment(id);
    }

    @PutMapping("/treatmentId/{id}")
    public void updateTreatment(@PathVariable long id, @RequestBody TreatmentDTO treatmentDTO) {
        treatmentService.updateTreatment(id, treatmentDTO);
    }

}
