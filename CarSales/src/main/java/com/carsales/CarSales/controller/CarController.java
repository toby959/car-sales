package com.carsales.CarSales.controller;

import com.carsales.CarSales.exception.ResourceNotFoundException;
import com.carsales.CarSales.model.Car;
import com.carsales.CarSales.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }
//######################################
    @GetMapping("/{id}") // Método para encontrar un coche por ID
    public ResponseEntity<Car> findById(@PathVariable Integer id) {
        Car car = carService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car con ID " + id + " no encontrado"));
        return ResponseEntity.ok(car);
    }
//########################################

    @PutMapping("/{id}")
    public Car updateCar(@RequestBody Car car, @PathVariable Integer id) {
        car.setIdCar(id);
        return carService.updateCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);

    }
}
