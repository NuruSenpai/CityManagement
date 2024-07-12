package org.example.citymanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.citymanagement.enums.SexType;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @Enumerated(EnumType.STRING)
    private SexType sexType;


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Car> car;

    @ManyToMany
    @JoinTable(
            name = "person_home",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "home_id")
    )
    private List<Home> homes;



}
