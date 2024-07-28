package org.example.citymanagement.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.citymanagement.enums.SexType;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private String surname;
    private List<CarDTO> cars;
    private BigDecimal balance;


    @Enumerated(EnumType.STRING)
    private SexType sexType;
}
