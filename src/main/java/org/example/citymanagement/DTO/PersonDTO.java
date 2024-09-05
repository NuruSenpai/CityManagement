package org.example.citymanagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.citymanagement.enums.PersonStatus;
import org.example.citymanagement.enums.SexType;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private String surname;
    private BigDecimal balance;

    private PersonStatus status;

    private SexType sexType;
}
