package org.example.citymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Home {
    @Id
    @GeneratedValue
    private long id;
    private String address;
    private int numberOfRooms;

    @ManyToMany(mappedBy = "homes")
    private Set<Person> persons = new HashSet<>();


}
