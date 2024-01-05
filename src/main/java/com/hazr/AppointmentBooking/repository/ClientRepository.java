package com.hazr.AppointmentBooking.repository;

import com.hazr.AppointmentBooking.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByFirstnameIgnoreCaseContainingOrSurnameIgnoreCaseContaining(String searchTerm1, String searchTerm2);
}
