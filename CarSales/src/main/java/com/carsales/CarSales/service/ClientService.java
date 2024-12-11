package com.carsales.CarSales.service;

import com.carsales.CarSales.model.Client;
import com.carsales.CarSales.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

@Autowired
public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
}


    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client createClient(Client client) {
       return clientRepository.save(client);
    }

    // Método para encontrar un cliente por ID
    public Optional<Client> findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
        return clientRepository.findById(id);
    }
    public Client updateClient(Client client) {
       return clientRepository.save(client);
}


    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }
}
