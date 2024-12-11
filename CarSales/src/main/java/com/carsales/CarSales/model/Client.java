package com.carsales.CarSales.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
//eliminamos @Data por bucle
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    private String name;

    private String nationality;

    private String phone;

    private String email;

    private String address;

    @OneToOne//(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "car_id")
//    @JsonManagedReference // Indica que esta es la parte "principal" evita bucle
    private Car car;
}
