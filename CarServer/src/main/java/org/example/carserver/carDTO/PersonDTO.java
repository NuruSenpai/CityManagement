package org.example.carserver.carDTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.carserver.enums.SexType;

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

    private SexType sexType;
}
