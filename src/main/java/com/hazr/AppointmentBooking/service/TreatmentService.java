package com.hazr.AppointmentBooking.service;

import com.hazr.AppointmentBooking.dto.TreatmentDTO;
import com.hazr.AppointmentBooking.exception.TreatmentDoesNotExistException;
import com.hazr.AppointmentBooking.model.Treatment;
import com.hazr.AppointmentBooking.repository.TreatmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;

    private Treatment fetchTreatment(long id) {
        Optional<Treatment> treatment = treatmentRepository.findById(id);


        if (treatment.isEmpty()) {
            throw new TreatmentDoesNotExistException("No Treatment with the id: " + id);
        }
        return treatment.get();
    }


    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    public List<Treatment> fetchAllTreatments() {
        return treatmentRepository.findAll();
    }

    public Treatment fetchTreatmentById(long id) {
        return this.fetchTreatment(id);
    }

    public void createTreatment(TreatmentDTO treatmentDTO) {
        Treatment treatment = new Treatment(treatmentDTO.getTreatmentName(), treatmentDTO.getPrice(), treatmentDTO.getDurationMinutes());
        treatmentRepository.save(treatment);
    }


    public void deleteTreatment(long id) {
        treatmentRepository.delete(this.fetchTreatment(id));
    }

    @Transactional
    public void updateTreatment(long id, TreatmentDTO treatmentDTO) {

        Treatment treatmentDetails = this.fetchTreatment(id);

        System.out.println(treatmentDetails);

        if(treatmentDTO.getTreatmentName() != null && !treatmentDTO.getTreatmentName().isEmpty() && !Objects.equals(treatmentDTO.getTreatmentName(), treatmentDetails.getTreatmentName())) {
            treatmentDetails.setTreatmentName(treatmentDTO.getTreatmentName());
            System.out.println("this gets here");
        }

        if(treatmentDTO.getPrice() != null && !treatmentDTO.getPrice().isNaN() && !Objects.equals(treatmentDTO.getPrice(), treatmentDetails.getPrice())) {
            treatmentDetails.setPrice(treatmentDTO.getPrice());
        }

        if(treatmentDTO.getDurationMinutes() != null && !Objects.equals(treatmentDTO.getDurationMinutes(), treatmentDetails.getDurationMinutes())) {
            treatmentDetails.setDurationMinutes(treatmentDTO.getDurationMinutes());
        }

    }
}
