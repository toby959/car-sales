package com.carsales.CarSales.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
//eliminamos @Data por bucle
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCar;

    private String name;

    private String model;

    private Double price;

    private String brand;

    private String colour;

    private Integer mileage;

    @Column(name = "number_of_doors")
    private Integer numberOfDoors;

    @Column(name = "fuel_type")
    private String fuelType;

//    private boolean condition;

//    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL) // Relación inversa
//    @JsonBackReference // Indica que esta es la parte "hija"
//    private Client client; // Relación con Client

}
