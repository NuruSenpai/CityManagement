package org.example.citymanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Car.findAllByPersonId", query = "select c FROM Car c WHERE c.person.id = :personId")
})
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String brand;
    private  String model;
    private  String color;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private Person person;
}
