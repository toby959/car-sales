package com.carsales.CarSales.loaders;

import com.carsales.CarSales.model.Car;
import com.carsales.CarSales.model.Cars;
import com.carsales.CarSales.repository.CarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class CarJsonLoader implements CommandLineRunner {

    private final CarRepository carRepository;
    private final ObjectMapper objectMapper;


    public CarJsonLoader(CarRepository carRepository, ObjectMapper objectMapper) {
        this.carRepository = carRepository;
        this.objectMapper = objectMapper;
    }
    @Override
    public void run(String... args) throws Exception {

        try (InputStream inputStream = getClass().getResourceAsStream("/data/car.json")) {
            if (inputStream == null) {
                throw new RuntimeException("No se pudo cargar el archivo car.json");
            }
/*            Movie[] movies = objectMapper.readValue(inputStream, Movie[].class); // Suponiendo que el JSON es un array de objetos Run
            for (Movie movie : movies) {
                movieRepository.save(movie); // Guarda cada objeto Run en el repositorio

 */
            // Cambia esto para leer el objeto Movies
            Cars carsContainer = objectMapper.readValue(inputStream, Cars.class);
            for (Car car : carsContainer.cars()) {
                carRepository.save(car); // Guarda cada objeto Movie en el repositorio
            }
            System.out.println("Datos cargados desde car.json");
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar los datos desde car.json", e);
        }
    }
}
