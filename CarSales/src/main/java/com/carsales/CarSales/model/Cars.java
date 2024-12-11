package com.carsales.CarSales.model;

import java.util.List;

public class Cars {

    private List<Car> cars;


    public Cars() {}

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> cars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
