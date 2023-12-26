package com.hazr.AppointmentBooking.controller;

import com.hazr.AppointmentBooking.dto.ClientDTO;
import com.hazr.AppointmentBooking.model.Client;
import com.hazr.AppointmentBooking.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "http://localhost:5173")
public class ClientController {


    private final ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public List<Client> getAllClients() {
        return clientService.fetchAllClients();
    }

    @GetMapping("/clientId/{id}")
    public Client getClientById(@PathVariable long id) {
        return clientService.fetchClientById(id);
    }

    @PostMapping("/")
    public void createClient(@RequestBody ClientDTO clientDTO) {
        clientService.createClient(clientDTO);
    }

    @DeleteMapping("/clientId/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.deleteClient(id);
    }

    @PutMapping("/clientId/{id}")
    public void updateClient(@PathVariable long id, @RequestBody ClientDTO clientDTO) {
        clientService.updateClient(id, clientDTO);
    }

}
