package com.hazr.AppointmentBooking.service;


import com.hazr.AppointmentBooking.dto.ClientDTO;
import com.hazr.AppointmentBooking.exception.ClientDoesNotExistException;
import com.hazr.AppointmentBooking.model.Client;
import com.hazr.AppointmentBooking.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client fetchClient(Long id) {

        Optional<Client> client = clientRepository.findById(id);

        if (client.isEmpty()) {
            throw new ClientDoesNotExistException("Could not find Client with id: " + id);
        }

        return client.get();
    }

    public List<Client> fetchAllClients() {
        return clientRepository.findAll();
    }

    public Client fetchClientById(long id) {
        return this.fetchClient(id);
    }

    public void createClient(ClientDTO clientDTO) {
        Client client = new Client(clientDTO.getFirstname(), clientDTO.getSurname(), clientDTO.getEmail(), clientDTO.getTelephone());
        clientRepository.save(client);
    }

    public void deleteClient(long id) {
        clientRepository.delete(this.fetchClientById(id));
    }

    @Transactional
    public void updateClient(long id, ClientDTO clientDTO) {

        Client clientDetails = this.fetchClient(id);

        if(clientDTO.getFirstname() != null && !clientDTO.getFirstname().isEmpty() && !Objects.equals(clientDTO.getFirstname(), clientDetails.getFirstname())) {
            clientDetails.setFirstname(clientDetails.getFirstname());
        }

        if(clientDTO.getSurname() != null && !clientDTO.getSurname().isEmpty() && !Objects.equals(clientDTO.getSurname(), clientDetails.getSurname())) {
            clientDetails.setSurname(clientDetails.getSurname());
        }

        if(clientDTO.getEmail() != null && !clientDTO.getEmail().isEmpty() && !Objects.equals(clientDTO.getEmail(), clientDetails.getEmail())) {
            clientDetails.setEmail(clientDetails.getEmail());
        }

        if(clientDTO.getTelephone() != null && !clientDTO.getTelephone().isEmpty() && !Objects.equals(clientDTO.getTelephone(), clientDetails.getTelephone())) {
            clientDetails.setTelephone(clientDetails.getTelephone());
        }


    }
}
