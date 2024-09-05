package org.example.citymanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.citymanagement.enums.PersonStatus;
import org.example.citymanagement.enums.SexType;

import java.math.BigDecimal;
import java.util.List;

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
    private BigDecimal balance;


    @Enumerated(EnumType.STRING)
    private PersonStatus status = PersonStatus.ACTIVE;

    @Enumerated(EnumType.STRING)
    private SexType sexType;




    @ManyToMany
    @JoinTable(
            name = "person_home",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "home_id")
    )
    private List<Home> homes;



}
