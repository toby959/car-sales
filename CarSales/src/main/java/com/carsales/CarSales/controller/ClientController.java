package com.carsales.CarSales.controller;

import com.carsales.CarSales.model.Client;
import com.carsales.CarSales.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }


    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable Integer id) {
        client.setIdClient(id); // Asegúrate de que el ID se establece en el objeto Car
        return clientService.createClient(client);
    }

}
