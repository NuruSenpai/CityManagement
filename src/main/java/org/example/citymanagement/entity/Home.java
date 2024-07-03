package org.example.citymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
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
    private String street;
    private String numberOfHome;
    private int numberOfRooms;

    @ManyToMany(mappedBy = "homes")
    private List<Person> persons;


}
