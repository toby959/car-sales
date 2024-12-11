package com.carsales.CarSales.repository;

import com.carsales.CarSales.model.Car;
import com.carsales.CarSales.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
