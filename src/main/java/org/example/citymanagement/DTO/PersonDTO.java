package org.example.citymanagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private String surname;
    private List<CarDTO> cars;
}
