package org.example.carserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.carserver.enums.CarStatus;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String brand;
    private  String model;
    private  String color;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CarStatus status = CarStatus.ACTIVE;

    @Column(name = "person_id")
    private Long personID;
}
