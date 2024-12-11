package com.carsales.CarSales.service;

import com.carsales.CarSales.exception.ResourceNotFoundException;
import com.carsales.CarSales.model.Car;
import com.carsales.CarSales.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

   @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }

//#################################################
// Método para encontrar un coche por ID
public Optional<Car> findById(Integer id) {
    if (id == null) {
        throw new IllegalArgumentException("El ID no puede ser nulo");
    }
    return Optional.ofNullable(carRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Car con ID " + id + " no encontrado")));
}
//#################################################
}
