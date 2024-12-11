package com.carsales.CarSales.repository;


import com.carsales.CarSales.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
