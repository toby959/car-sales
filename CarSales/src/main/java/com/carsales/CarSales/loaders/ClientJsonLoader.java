package com.carsales.CarSales.loaders;

import com.carsales.CarSales.model.Client;
import com.carsales.CarSales.model.Clients;
import com.carsales.CarSales.repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class ClientJsonLoader implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ObjectMapper objectMapper;


    public ClientJsonLoader(ClientRepository clientRepository, ObjectMapper objectMapper) {
        this.clientRepository = clientRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public void run(String... args) throws Exception {
        try (InputStream inputStream = getClass().getResourceAsStream("/data/client.json")) {
            if (inputStream == null) {
                throw new RuntimeException("No se pudo cargar el archivo client.json");
            }

            // Cambia esto para leer el objeto Movies
            Clients clientsContainer = objectMapper.readValue(inputStream, Clients.class);
            for (Client client : clientsContainer.clients()) {
                clientRepository.save(client); // Guarda cada objeto Movie en el repositorio
            }
            System.out.println("Datos cargados desde client.json");
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar los datos desde client.json", e);
        }
    }
}

